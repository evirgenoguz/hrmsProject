package com.example.hrmsProject.core.utilities.adapters.concretes;

import org.springframework.stereotype.Component;

import com.example.hrmsProject.core.utilities.adapters.abstracts.EmailVerificationService;

@Component
public class EmailVerificationManager implements EmailVerificationService  {

	
	@Override
	public Boolean emailVerify(String email) {
		return true; //direkt true döndürüyorum	
	}

	@Override
	public boolean emailDomainVerify(String email, String website) {
		
		if(email.contains(website)) {
			return true;
		} //if bloğu yerine regex kontrol yapılmalı ama bilmiyorum
		
		
		return true;
	}

	@Override
	public String emailSend(String email) {
		return null;
	}

}
