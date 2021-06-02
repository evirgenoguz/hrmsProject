package com.example.hrmsProject.core.utilities.adapters.abstracts;

import org.springframework.stereotype.Service;

import com.example.hrmsProject.entities.concretes.EmployeeUser;

@Service
public interface MernisService {
	
	public Boolean checkIfEmployeeUserRealPerson(EmployeeUser employeeUser);

}
