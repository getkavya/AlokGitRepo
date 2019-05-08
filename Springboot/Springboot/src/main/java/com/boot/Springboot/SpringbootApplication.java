package com.boot.Springboot;

import org.slf4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringbootApplication {

	public static void main(String[] args) {
	    //Logger log = new ch.qos.logback.classic.LoggerContext().getLogger(SpringbootApplication.class);
		ConfigurableApplicationContext c= SpringApplication.run(SpringbootApplication.class, args);
		
		for(String beanName : c.getBeanDefinitionNames()) {
			//System.out.println("Bean name-->" + beanName);
			//System.out.println(log.isErrorEnabled());
			//log.debug("Bean name-->" + beanName);
		}
	}
}
