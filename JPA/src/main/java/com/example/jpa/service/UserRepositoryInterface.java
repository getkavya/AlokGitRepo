package com.example.jpa.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jpa.entity.User;

public interface UserRepositoryInterface extends JpaRepository<User, Long>{

}
