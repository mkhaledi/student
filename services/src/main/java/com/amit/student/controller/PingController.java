package com.amit.student.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class PingController {
    private static final Logger LOGGER = LoggerFactory.getLogger(PingController.class);

    @GetMapping("/")
    public void ping() {
        LOGGER.trace("Received ping");
    }

}