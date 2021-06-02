package com.example.hrmsProject.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.hrmsProject.business.abstracts.EmployeeUserService;
import com.example.hrmsProject.core.utilities.results.Result;
import com.example.hrmsProject.entities.concretes.EmployeeUser;

@RestController
@RequestMapping("/api/employeeusers")
public class EmployeeUsersController {
	
	private EmployeeUserService employeeUserService;
	
	
	@Autowired
	public EmployeeUsersController(EmployeeUserService employeeUserService) {
		super();
		this.employeeUserService = employeeUserService;
	}



	@PostMapping("/register")
	public Result register(@RequestBody EmployeeUser employeeUser, @RequestParam String repeatPassword) {
		return this.employeeUserService.register(employeeUser, repeatPassword);
	}
}

