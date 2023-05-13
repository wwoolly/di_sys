package ru.nsu.fit.kn.services;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.paukov.combinatorics3.Generator;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import ru.nsu.fit.kn.messages.CrackHashManagerRequest;
import ru.nsu.fit.kn.messages.CrackHashWorkerResponse;
import ru.nsu.fit.kn.messages.InternalRequestFactory;

import java.util.ArrayList;
import java.util.List;


@Service
@Profile("worker")
public class WorkerService {
    private static final Logger log = LogManager.getLogger(WorkerService.class);

    /*
     * TODO:
     *  3. double-check that messages are persistent https://www.rabbitmq.com/confirms.html
     */

    @Autowired
    AmqpTemplate rabbitTemplate;
    @Autowired
    private Queue responseQueue;

    @Async
    public void callDoWork(CrackHashManagerRequest workRequest) {
        List<String> results = searchForResults(workRequest);

        CrackHashWorkerResponse response = InternalRequestFactory.forgeResponse(workRequest, results);

        rabbitTemplate.convertAndSend(responseQueue.getName(), response);
        log.info("sent message to queue " + responseQueue.getName());
    }

    /*
     * TODO: in config with many workers:
     *  count maxWork, batchWork = maxWork/partCount
     *  .skip(batchWork*partNumber).limit(batchWork)
     */
    private ArrayList<String> searchForResults(CrackHashManagerRequest workRequest) {
        var list =  new ArrayList<String>();
        for (int i = 1; i <= workRequest.getMaxLength(); i++) {
            Generator.combination(workRequest.getAlphabet().getSymbols())
                    .multi(i)
                    .stream()
                    .forEach(comb -> {
                            var combString = String.join("", comb);
                            if (DigestUtils.md5Hex(combString).equals(workRequest.getHash())) {
                                list.add(combString);
                            }
                    });
        }
        return list;
    }
}
