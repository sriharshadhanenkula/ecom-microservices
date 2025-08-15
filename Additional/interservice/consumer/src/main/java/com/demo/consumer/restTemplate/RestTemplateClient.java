package com.demo.consumer.restTemplate;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class RestTemplateClient {

    private final RestTemplate restTemplate;

//    private static final String PROVIDER_URL = "http://localhost:8081";
    private static final String PROVIDER_URL = "http://provider";

    public String getInstanceInfo(){
        return restTemplate.getForObject(PROVIDER_URL +"/instance-info", String.class);
    }
}
