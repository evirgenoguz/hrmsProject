package com.example.hrmsProject.business.abstracts;

import com.example.hrmsProject.core.utilities.results.Result;
import com.example.hrmsProject.entities.concretes.EmployerUser;

public interface EmployerUserService {
	Result register(EmployerUser employerUser, String passwordRepeat);
}
