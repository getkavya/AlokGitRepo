package com.example.jpa;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.jpa.entity.User;
import com.example.jpa.service.UserDAOService;

@Component
public class UserDAOServiceCommandLineRunner implements CommandLineRunner{
	
	private static final Logger log = LoggerFactory.getLogger(UserDAOServiceCommandLineRunner.class);
			
			
	
	@Autowired
	private UserDAOService userDAOService;

	@Override
	public void run(String... args) throws Exception {
		User user = new User ("Alok111", "XYZ");
		long id = userDAOService.insert(user);
		log.info("New latest User test ==" +user);
		System.out.println("New User ==" +user);
		
	}

}
