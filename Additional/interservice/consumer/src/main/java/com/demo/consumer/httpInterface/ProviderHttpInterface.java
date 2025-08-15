package com.demo.consumer.httpInterface;

import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

@HttpExchange
public interface ProviderHttpInterface {
    @GetExchange("/instance-info")
    String getInstanceInfo();

}
