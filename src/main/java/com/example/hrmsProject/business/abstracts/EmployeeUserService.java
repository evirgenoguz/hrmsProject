package com.example.hrmsProject.business.abstracts;

import java.util.List;

import com.example.hrmsProject.core.utilities.results.DataResult;
import com.example.hrmsProject.core.utilities.results.Result;
import com.example.hrmsProject.entities.concretes.EmployeeUser;

public interface EmployeeUserService {
	Result register(EmployeeUser employeeUser, String passwordRepeat);
	DataResult<List<EmployeeUser>> getAll();
}
