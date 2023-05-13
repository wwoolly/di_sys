package ru.nsu.fit.kn.api;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import ru.nsu.fit.kn.messages.CrackHashWorkerResponse;
import ru.nsu.fit.kn.services.ManagerService;


@Component
@RabbitListener(queues = "${rabbitmq.response.queue}", id = "manager")
@Profile("manager")
public class RabbitManagerController {
    private static final Logger log = LogManager.getLogger(RabbitManagerController.class);

    @Autowired
    ManagerService managerService;

    @RabbitHandler
    public void receiver(CrackHashWorkerResponse workerResponse) {
        log.info("rabbit-consuming request: " + workerResponse.getRequestId());
        log.info("Starting to work on: "+ workerResponse.getRequestId());
        managerService.callLogUpdate(workerResponse);
    }
}