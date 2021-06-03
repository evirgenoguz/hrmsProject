package com.example.hrmsProject.core.utilities.adapters.abstracts;

import org.springframework.stereotype.Service;

@Service
public interface EmailVerificationService {
	public Boolean emailVerify(String email);
	public boolean emailDomainVerify(String email, String website);
	public String emailSend(String email);
}
