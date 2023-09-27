package com.springboot.jwt.repository;

import org.springframework.data.repository.CrudRepository;

import com.springboot.jwt.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
	
	User findByEmailIgnoreCase(String username);
}
