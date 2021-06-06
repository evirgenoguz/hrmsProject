package com.example.hrmsProject.business.abstracts;

import java.util.List;

import com.example.hrmsProject.core.utilities.results.DataResult;
import com.example.hrmsProject.core.utilities.results.Result;
import com.example.hrmsProject.entities.concretes.EmployerUser;

public interface EmployerUserService {
	Result register(EmployerUser employerUser, String passwordRepeat);
	DataResult<List<EmployerUser>> getAll();
}
