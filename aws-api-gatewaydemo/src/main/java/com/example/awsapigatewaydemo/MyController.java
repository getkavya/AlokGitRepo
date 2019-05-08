package com.example.awsapigatewaydemo;

import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

@GetMapping("/hello")
public String sayHello(@RequestParam String msg) {
	return "Hello "+ msg + " :: Responded on " + new Date() + " :: Welcome to AWS api gateway!!";
}
}
