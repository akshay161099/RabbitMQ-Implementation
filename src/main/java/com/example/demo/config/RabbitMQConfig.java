package com.example.demo.config;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
    public static final String QUEUE_NAME = "myQueue";
    public static final String QUEUE_NAME2 = "myQueue2";
    public static final String EXCHANGE_NAME = "exchange";

    @Bean
    public Queue queue() {
        return new Queue(QUEUE_NAME,false);
    }

    @Bean
    public Queue queue1() {return new Queue(QUEUE_NAME2,false);}

    @Bean
    public FanoutExchange exchange() {
        return new FanoutExchange(EXCHANGE_NAME);
    }

    @Bean
    public Binding binding (Queue queue, FanoutExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange);//.with("routing.key");
    }

    @Bean
    public Binding binding1 (Queue queue1,FanoutExchange exchange) {
        return BindingBuilder.bind(queue1).to(exchange);
    }
}
