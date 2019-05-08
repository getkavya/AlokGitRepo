package com.example.oauth.jwt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class SpringOAuthJwtApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringOAuthJwtApplication.class, args);
	}

	
	@GetMapping(value = "/products")
	   public String getProductName() {
	      return "Honey";   
	   }
}
