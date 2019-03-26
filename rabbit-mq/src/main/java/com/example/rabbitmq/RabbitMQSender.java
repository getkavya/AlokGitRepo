package com.example.rabbitmq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.rabbitmq.model.Employee;

@Service
public class RabbitMQSender {
	
	@Autowired
	private AmqpTemplate rabbitTemplate1;
	
	@Autowired
	private DirectExchange exchange;
	
	@Value("${javainuse.rabbitmq.routingkey}")
	private String routingkey;
		
	/*@Value("${javainuse.rabbitmq.exchange}")
	String exchange;

	@Value("${javainuse.rabbitmq.routingkey}")
	private String routingkey;*/
	
	public void send(Employee emp) {

		rabbitTemplate1.convertAndSend(exchange.getName(), routingkey, emp);
		
		System.out.println("Send msg = " + emp);
	    
	}
}