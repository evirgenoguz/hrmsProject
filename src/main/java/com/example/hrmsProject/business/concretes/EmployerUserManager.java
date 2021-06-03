package com.example.hrmsProject.business.concretes;

import com.example.hrmsProject.business.abstracts.EmployerUserService;
import com.example.hrmsProject.core.utilities.results.Result;
import com.example.hrmsProject.entities.concretes.EmployerUser;

public class EmployerUserManager implements EmployerUserService{
	@Override
	public Result register(EmployerUser employerUser, String passwordRepeat) {
		// TODO Auto-generated method stub
		return null;
	}
	
	//yyarın burayı yap
	
	public boolean hasEmptyField(EmployerUser employerUser) {
		
		if (employerUser.getCompanyName().isEmpty() 
				|| employerUser.getWebAdress().isEmpty()
				|| employerUser.getPhoneNumber().isEmpty() 
				|| employerUser.getEmail().isEmpty()
				|| employerUser.getPassword().isEmpty()){
			return true;
		} 
		else {
			return false;
		}
	}

}
