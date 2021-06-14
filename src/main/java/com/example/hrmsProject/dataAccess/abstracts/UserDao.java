package com.example.hrmsProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hrmsProject.entities.concretes.User;

public interface UserDao extends JpaRepository<User, Integer>{
	
	User getByEmail(String email);

}
