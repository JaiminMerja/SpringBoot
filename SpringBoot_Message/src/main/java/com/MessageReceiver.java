package com;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MessageReceiver 
{
	
	public String ms ;
	
	@RabbitListener(queues = "hello")
	public void receive(String msg)
	{
		ms = msg;
		System.out.println("Recived: " +msg);
	}
}
