package com.example.hrmsProject.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.hrmsProject.business.abstracts.EmployerUserService;
import com.example.hrmsProject.core.utilities.results.DataResult;
import com.example.hrmsProject.core.utilities.results.Result;
import com.example.hrmsProject.entities.concretes.EmployerUser;

@RestController
@RequestMapping("/api/employerusers")
//bu zincirin neresinde hata var anlayamadım aq ya
public class EmployerUsersController {
	
	private EmployerUserService employerUserService;

	public EmployerUsersController(EmployerUserService employerUserService) {
		super();
		this.employerUserService = employerUserService;
	}

	@PostMapping("/register")
	public Result register(@RequestBody EmployerUser employerUser, @RequestParam String repeatPassword) {
		return this.employerUserService.register(employerUser, repeatPassword);
	}
	
	@GetMapping("/getall")
	public DataResult<List<EmployerUser>> getAll(){
		return this.employerUserService.getAll();
	}
	
}

