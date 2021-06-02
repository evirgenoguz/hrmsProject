package com.example.hrmsProject.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hrmsProject.business.abstracts.UserService;
import com.example.hrmsProject.core.utilities.results.DataResult;
import com.example.hrmsProject.core.utilities.results.SuccessDataResult;
import com.example.hrmsProject.dataAccess.abstracts.UserDao;
import com.example.hrmsProject.entities.concretes.User;

@Service
public class UserManager implements UserService {

	private UserDao userDao;
	
	
	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}



	@Override
	public DataResult<User> getByEmail(String email) {
		return new SuccessDataResult<User>(this.userDao.getByEmail(email), "Maille Kullanıcı Arama İşlemi");
	}
	
}
