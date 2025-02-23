package com.example.demo.service;

import com.example.demo.config.RabbitMQConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQConsumer {
    
    @RabbitListener(queues = RabbitMQConfig.QUEUE_NAME)
    public void listen1(String message){
        System.out.println("Message received - " + message);
    }
    @RabbitListener(queues = RabbitMQConfig.QUEUE_NAME2)
    public void listen (String message) {
        System.out.println("Message read by consumer in queue 2 - "+message);
    }
}
