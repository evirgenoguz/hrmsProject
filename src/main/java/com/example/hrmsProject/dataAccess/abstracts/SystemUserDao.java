package com.example.hrmsProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hrmsProject.entities.concretes.SystemUser;

public interface SystemUserDao extends JpaRepository<SystemUser, Integer>{
	
}
