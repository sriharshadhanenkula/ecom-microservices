package com.ecommerce.notification;

import com.ecommerce.notification.payload.OrderCreatedEvent;
import com.ecommerce.notification.payload.OrderStatus;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class OrderEventConsumer {

    @RabbitListener(queues = "${rabbitmq.queue.name}")
    public void handleOrderEvent(OrderCreatedEvent orderEvent){
        System.out.println("Received order Event: "+ orderEvent);

        long orderId = orderEvent.getOrderId();
        OrderStatus status = orderEvent.getStatus();

        System.out.println("Order Id: "+ orderId);
        System.out.println("Order Status: "+ status);

        // update Database
        // send notification
        // send email
        // generate Invoice
        // send seller notification
    }

}
