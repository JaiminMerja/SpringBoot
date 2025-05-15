package com;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig 
{

    public static final String QUEUE_NAME = "message_queue";
    public static final String EXCHANGE_NAME = "hello-exchange";
    public static final String ROUTING_KEY = "hello.key";

    @Bean
    public Queue helloQueue() 
    {
        return new Queue(QUEUE_NAME, false);
    }

    @Bean
    public DirectExchange helloExchange() 
    {
        return new DirectExchange(EXCHANGE_NAME);
    }

    @Bean
    public Binding binding(Queue helloQueue, DirectExchange helloExchange) 
    {
        return BindingBuilder.bind(helloQueue).to(helloExchange).with(ROUTING_KEY);
    }
}
