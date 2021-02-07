package com.workflow.github;

import com.workflow.github.config.BusinessConfig;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Scanner;

@Component
@Slf4j
public class WorkflowService {

    @Autowired
    private CloseableHttpClient httpClient;
    @Autowired
    private BusinessConfig businessConfig;

    public String message() throws IOException {

        log.info(businessConfig.getDescription());
        log.info(businessConfig.getName());
        log.info("{}", businessConfig.getRule().getNumber());

        callExternalAPI();

        log.warn("This is the info log for azure application insights");


        return "Hello";
    }

    private void callExternalAPI() throws IOException {
        HttpGet httpget = new HttpGet("https://my-json-server.typicode.com/kasdihacene/JsonServer/informations");
        HttpResponse httpresponse = httpClient.execute(httpget);

        Scanner sc = new Scanner(httpresponse.getEntity().getContent());

        //Printing the status line
        System.out.println(httpresponse.getStatusLine());
        while(sc.hasNext()) {
            System.out.println(sc.nextLine());
        }
    }
}
