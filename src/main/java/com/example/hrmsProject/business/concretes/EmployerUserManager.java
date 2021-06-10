package com.example.hrmsProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hrmsProject.business.abstracts.EmployerUserService;
import com.example.hrmsProject.business.abstracts.SystemUserService;
import com.example.hrmsProject.core.utilities.adapters.abstracts.EmailVerificationService;
import com.example.hrmsProject.core.utilities.results.DataResult;
import com.example.hrmsProject.core.utilities.results.ErrorResult;
import com.example.hrmsProject.core.utilities.results.Result;
import com.example.hrmsProject.core.utilities.results.SuccessDataResult;
import com.example.hrmsProject.core.utilities.results.SuccessResult;
import com.example.hrmsProject.dataAccess.abstracts.EmployerUserDao;
import com.example.hrmsProject.entities.concretes.EmployerUser;

@Service
public class EmployerUserManager implements EmployerUserService{
	
	private EmployerUserDao employerUserDao;
	private EmailVerificationService emailVerificationService;
	private SystemUserService systemUserService;
	
	
	@Autowired
	public EmployerUserManager(EmployerUserDao employerUserDao, EmailVerificationService emailVerificationService,
			SystemUserService systemUserService) {
		super();
		this.employerUserDao = employerUserDao;
		this.emailVerificationService = emailVerificationService;
		this.systemUserService = systemUserService;
	}

	@Override
	public Result register(EmployerUser employerUser, String passwordRepeat) {
		
		if (this.hasEmptyField(employerUser)) {
			return new ErrorResult("Alanlar Boş Bırakılamaz");
		}
		else if(!this.emailVerificationService.emailDomainVerify(employerUser.getEmail(), employerUser.getWebAdress())) {
			return new ErrorResult("Şirket mailiyle kaydolmanız gereklidir.");
		}
		else if(!employerUser.getPassword().equals(passwordRepeat)) {
			return new ErrorResult("Şifre tekrarı yanlış!");
		}
		//else if(!this.systemUserService.registerPermit()) {
		//	return new ErrorResult("Sistem Personeli Onayı Gerekiyor");
		//}
		else{
			this.employerUserDao.save(employerUser);
			return new SuccessResult("iş Veren Başarıyla Kayıt Oldu");
		}
		
	}
	
	@Override
	public DataResult<List<EmployerUser>> getAll() {
		
		return new SuccessDataResult<List<EmployerUser>>(this.employerUserDao.findAll(), "İş Verenler Listelendi");
	}
	
	
	public boolean hasEmptyField(EmployerUser employerUser) {
		
		if (employerUser.getCompanyName().isEmpty() 
				|| employerUser.getWebAdress().isEmpty()
				|| employerUser.getPhoneNumber().isEmpty() 
				|| employerUser.getEmail().isEmpty()
				|| employerUser.getPassword().isEmpty()){
			return true;
		} 
		else {
			return false;
		}
	}

	

}
