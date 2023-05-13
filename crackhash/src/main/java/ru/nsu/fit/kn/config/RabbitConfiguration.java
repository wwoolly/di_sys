package ru.nsu.fit.kn.config;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.MarshallingMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import ru.nsu.fit.kn.messages.CrackHashManagerRequest;
import ru.nsu.fit.kn.messages.CrackHashWorkerResponse;

@Configuration
@EnableRabbit
public class RabbitConfiguration {
    @Value("${rabbitmq.request.queue}")
    String requestQueueName;

    @Value("${rabbitmq.request.exchange}")
    String requestExchange;

    @Value("${rabbitmq.request.routingkey}")
    private String requestRoutingKey;

    @Value("${rabbitmq.response.queue}")
    String responseQueueName;

    @Value("${rabbitmq.response.exchange}")
    String responseExchange;

    @Value("${rabbitmq.response.routingkey}")
    private String responseRoutingKey;

    @Value("${rabbitmq.username}")
    private String username;

    @Value("${rabbitmq.password}")
    private String password;

    @Value("${rabbitmq.host}")
    private String host;

    @Value("${rabbitmq.virtualhost}")
    private String virtualHost;

    @Bean
    Queue requestQueue() {
        return new Queue(requestQueueName, true);
    }

    @Bean
    DirectExchange requestExchange() {
        return new DirectExchange(requestExchange);
    }

    @Bean
    Binding requestBinding(Queue requestQueue, DirectExchange requestExchange) {
        return BindingBuilder.bind(requestQueue).to(requestExchange).with(requestRoutingKey);
    }

    @Bean
    Queue responseQueue() {
        return new Queue(responseQueueName, true);
    }

    @Bean
    DirectExchange responseExchange() {
        return new DirectExchange(responseExchange);
    }

    @Bean
    Binding responseBinding(Queue responseQueue, DirectExchange responseExchange) {
        return BindingBuilder.bind(responseQueue).to(responseExchange).with(responseRoutingKey);
    }

    @Bean
    public MessageConverter jsonMessageConverter() {
        var marshaller = new Jaxb2Marshaller();
        marshaller.setClassesToBeBound(
                CrackHashManagerRequest.class,
                CrackHashWorkerResponse.class
        );
        return new MarshallingMessageConverter(marshaller);
    }

    @Bean
    public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory() {
        final SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory());
        factory.setMessageConverter(jsonMessageConverter());
        return factory;
    }

    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setVirtualHost(virtualHost);
        connectionFactory.setHost(host);
        connectionFactory.setUsername(username);
        connectionFactory.setPassword(password);
        return connectionFactory;
    }

    @Bean
    public AmqpTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jsonMessageConverter());
        return rabbitTemplate;
    }
}