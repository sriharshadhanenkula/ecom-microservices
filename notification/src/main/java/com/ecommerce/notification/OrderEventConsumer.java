package com.ecommerce.notification;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class OrderEventConsumer {

    @RabbitListener(queues = "${rabbitmq.queue.name}")
    public void handleOrderEvent(Map<String,Object> orderEvent){
        System.out.println("Received order Event: "+ orderEvent);

        long orderId = Long.parseLong(orderEvent.get("orderId").toString());
        String status = orderEvent.get("status").toString();

        System.out.println("Order Id: "+ orderId);
        System.out.println("Order Status: "+ status);
        
        // update Database
        // send notification
        // send email
        // generate Invoice
        // send seller notification
    }

}
