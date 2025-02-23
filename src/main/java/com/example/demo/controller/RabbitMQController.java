package com.example.demo.controller;

import com.example.demo.service.RabbitMQProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RabbitMQController {

    @Autowired
    RabbitMQProducer producer;
    @GetMapping("/send")
    public void sendMessage () {
        String message = "hello there whatsup";
        for (int i = 0;i<5;i++) {
            producer.sendMessage(message);
        }

    }
}
