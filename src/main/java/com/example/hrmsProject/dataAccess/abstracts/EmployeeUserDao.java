package com.example.hrmsProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hrmsProject.entities.concretes.EmployeeUser;

public interface EmployeeUserDao extends JpaRepository<EmployeeUser, Integer> {
	
	boolean existsEmployeeUserByIdentityNo(String identityNo);
	boolean existsEmployeeUserByEmail(String email);
	EmployeeUser getByEmailAndPassword(String email,String password);
	
}
