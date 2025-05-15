package com;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MessageReceiver 
{
    public String lastMessage;

    @RabbitListener(queues = RabbitMQConfig.QUEUE_NAME)
    
    public void receiveMessage(String message) 
    {
        lastMessage = message;
        System.out.println("Received from queue: " + message);
    }
}
