package com.workflow.github;

import com.microsoft.applicationinsights.TelemetryClient;
import com.microsoft.applicationinsights.telemetry.Duration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WorkflowService {
    private static final Logger LOGGER = LoggerFactory.getLogger(WorkflowService.class);

    @Autowired
    TelemetryClient telemetryClient;

    public String message() {

        LOGGER.warn("This is the info log for azure application insights");
        LOGGER.warn("This is the warn log for azure application insights");
        LOGGER.warn("This is the error log for azure application insights");

        //track a custom event
        this.telemetryClient.trackEvent("Sending a custom event...");

        //trace a custom trace
        this.telemetryClient.trackTrace("Sending a custom trace....");

        //track a custom metric
        this.telemetryClient.trackMetric("custom metric", 1.0);

        //track a custom dependency
        this.telemetryClient
                .trackDependency("SQL", "Insert", new Duration(0, 0, 1, 1, 1), true);

        return "Hello";
    }
}
