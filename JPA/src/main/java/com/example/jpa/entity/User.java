package com.example.jpa.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {
	public User(String name, String role) {
		super();
		this.name = name;
		this.role = role;
	}

	protected User() {
		
	}

	@Id
	@GeneratedValue
	private long id;
	private String name;
	private String role;
	
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", role=" + role + "]";
	}


	public long getId() {
		return id;
	}


	public String getName() {
		return name;
	}


	public String getRole() {
		return role;
	}
	

}
