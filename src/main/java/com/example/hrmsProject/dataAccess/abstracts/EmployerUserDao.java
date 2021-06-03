package com.example.hrmsProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hrmsProject.entities.concretes.EmployerUser;

public interface EmployerUserDao extends JpaRepository<EmployerUser, Integer>{
	boolean existsEmployerUserByEmail(String email); // uniqe mail kontrolü için
	EmployerUser getByEmailAndPassword(String email,String password); //login için
}
