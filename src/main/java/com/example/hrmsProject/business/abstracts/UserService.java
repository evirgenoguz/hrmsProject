package com.example.hrmsProject.business.abstracts;

import com.example.hrmsProject.core.utilities.results.DataResult;
import com.example.hrmsProject.entities.concretes.User;

public interface UserService {
	DataResult<User> getByEmail(String email);
}
