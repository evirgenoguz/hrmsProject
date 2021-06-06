package com.example.hrmsProject.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hrmsProject.business.abstracts.SystemUserService;
import com.example.hrmsProject.dataAccess.abstracts.SystemUserDao;


@Service
public class SystemUserManager implements SystemUserService{
	
	private SystemUserDao systemUserDao;

	@Autowired
	public SystemUserManager(SystemUserDao systemUserDao) {
		super();
		this.systemUserDao = systemUserDao;
	}

	@Override
	public boolean registerPermit() {
		//direkt olarak true döndürüyorum simule etmek için
		return true;
	}
	
	

}
