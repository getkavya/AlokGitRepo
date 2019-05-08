package com.example.jpa;


import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.jpa.entity.User;
import com.example.jpa.service.UserRepositoryInterface;

@Component
public class UserDAORepositoryCommandLineRunner implements CommandLineRunner{
	
	private static final Logger log = LoggerFactory.getLogger(UserDAORepositoryCommandLineRunner.class);
			
			
	
	@Autowired
	private UserRepositoryInterface userRepositoryInterface;

	@Override
	public void run(String... args) throws Exception {
		User user = new User ("JPACode", "XYZ");
		user = userRepositoryInterface.save(user);
		List<User> users= userRepositoryInterface.findAll();
		Optional<User> SinleUser = userRepositoryInterface.findById(1L);
		
		log.info("User Created ==" +user);
		log.info("All Users ==" +users);
		log.info("Single Users ==" +SinleUser);
		
		
	}

}
