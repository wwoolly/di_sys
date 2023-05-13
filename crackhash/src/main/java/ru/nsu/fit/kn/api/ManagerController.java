package ru.nsu.fit.kn.api;


import ru.nsu.fit.kn.messages.CrackRequest;
import ru.nsu.fit.kn.messages.CrackResponse;
import ru.nsu.fit.kn.messages.StatusResponse;
import ru.nsu.fit.kn.services.ManagerService;

import org.springframework.context.annotation.Profile;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Profile("manager")
public class ManagerController {
    private static final Logger log = LogManager.getLogger(ManagerController.class);

    @Autowired
    ManagerService managerService;

    @PostMapping(value = "/api/hash/crack", consumes = "application/json")
    public CrackResponse crackHash(@RequestBody CrackRequest crackRequest) {
        log.info("Received crack request with hash: {}", crackRequest);

        return managerService.callCrackService(crackRequest);
    }

    @GetMapping(value = "/api/hash/status")
    public StatusResponse getStatus(@RequestParam(name = "requestId") String hashId) {
        return managerService.getHashStatus(hashId);
    }
}