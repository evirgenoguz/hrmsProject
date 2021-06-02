package com.example.hrmsProject.business.abstracts;

import com.example.hrmsProject.core.utilities.results.Result;
import com.example.hrmsProject.entities.concretes.EmployeeUser;

public interface EmployeeUserService {
	Result register(EmployeeUser jobSeeker, String passwordRepeat);
}
