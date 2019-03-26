package com.example.rabbitmq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.rabbitmq.model.Employee;



@Service
public class RabbitMQConsumer {
	
	@Autowired
	private AmqpTemplate rabbitTemplate2;
	
	@Autowired
	private DirectExchange exchange;
	
	@Value("${javainuse.rabbitmq.routingkey}")
	private String routingkey;
	

	//@RabbitListener(queues = "${javainuse.rabbitmq.queue}")
	//@RabbitHandler
	public Employee recievedMessage() {		
		
	   Employee emp	= (Employee) rabbitTemplate2.receiveAndConvert("javainuse.queue");
	 				
		System.out.println("Recieved Message From RabbitMQ: " + emp);
		
		
		return emp;
		
	}
	
	
	/*@RabbitListener(queues = "${javainuse.rabbitmq.queue}")
	public void recievedMessage(Employee employee) {
		System.out.println("Recieved Message From RabbitMQ: " + employee);
	}*/
}




	



    