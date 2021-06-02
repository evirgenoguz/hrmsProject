package com.example.hrmsProject.core.utilities.adapters.concretes;

import org.springframework.stereotype.Component;

import com.example.hrmsProject.core.utilities.adapters.abstracts.EmailVerificationService;

@Component
public class EmailVerificationManager implements EmailVerificationService  {

	@Override
	public Boolean emailVerify(String email) {
		return true; //direkt true döndürüyorum	
	}

}
