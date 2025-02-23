package com.example.demo.service;

import com.example.demo.config.RabbitMQConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQProducer {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendMessage(String message){
        //rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_NANE,"routing.key",message);
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_NAME,"",message);
    }

}
