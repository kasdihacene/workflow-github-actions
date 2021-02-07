package com.workflow.github;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.math.BigInteger;

@RestController
@RequestMapping("demo")
public class WorkflowController {

    @Autowired
    private WorkflowService workflowService;

    @GetMapping(value = "actions", produces = MediaType.APPLICATION_JSON_VALUE)
    public HttpEntity<String> actions() throws IOException {

        // Simulate call service
        String message = workflowService.message();

        return new ResponseEntity<String>(message, HttpStatus.OK);
    }

    @GetMapping(value = "exception", produces = MediaType.APPLICATION_JSON_VALUE)
    public HttpEntity<String> exception() {

        // Simulate call service
        Long.parseLong("XXXX");

        return new ResponseEntity<String>("KO", HttpStatus.OK);
    }

}
