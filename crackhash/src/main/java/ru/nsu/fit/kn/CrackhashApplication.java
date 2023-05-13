package ru.nsu.fit.kn;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration(exclude={org.springframework.boot.autoconfigure.amqp.RabbitAutoConfiguration.class})
public class CrackhashApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrackhashApplication.class, args);
	}

}
