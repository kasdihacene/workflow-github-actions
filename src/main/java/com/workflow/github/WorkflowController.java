package com.workflow.github;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("demo")
public class WorkflowController {

    @Autowired
    private WorkflowService workflowService;

    @GetMapping(value = "actions", produces = MediaType.APPLICATION_JSON_VALUE)
    public HttpEntity<String> actions() {

        // Simulate call service
        String message = workflowService.message();

        return new ResponseEntity<String>(message, HttpStatus.OK);
    }

}
