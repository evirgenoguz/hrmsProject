package com.example.hrmsProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hrmsProject.business.abstracts.EmployeeUserService;
import com.example.hrmsProject.core.utilities.adapters.abstracts.EmailVerificationService;
import com.example.hrmsProject.core.utilities.adapters.abstracts.MernisService;
import com.example.hrmsProject.core.utilities.results.DataResult;
import com.example.hrmsProject.core.utilities.results.ErrorResult;
import com.example.hrmsProject.core.utilities.results.Result;
import com.example.hrmsProject.core.utilities.results.SuccessDataResult;
import com.example.hrmsProject.core.utilities.results.SuccessResult;
import com.example.hrmsProject.dataAccess.abstracts.EmployeeUserDao;
import com.example.hrmsProject.entities.concretes.EmployeeUser;

@Service
public class EmployeeUserManager implements EmployeeUserService{

	private EmployeeUserDao employeeUserDao;
	private EmailVerificationService emailVerificationService;
	private MernisService mernisService;
	
	
	
	@Autowired
	public EmployeeUserManager(EmployeeUserDao employeeUserDao, EmailVerificationService emailVerificationService,
			MernisService mernisService) {
		super();
		this.employeeUserDao = employeeUserDao;
		this.emailVerificationService = emailVerificationService;
		this.mernisService = mernisService;
	}



	@Override
	public Result register(EmployeeUser employeeUser, String passwordRepeat) {
		if (this.hasEmptField(employeeUser)) {
			return new ErrorResult("Tüm alanlar zorunludur");
		}
		else if(!this.mernisService.checkIfEmployeeUserRealPerson(employeeUser)) {
			return new ErrorResult("Girilen Bilgiler Gerçek bir Kişie Ait olmalıdır");
		}
		else if(!this.emailVerificationService.emailVerify(employeeUser.getEmail())) {
			return new ErrorResult("E mail geçerli değil");
		}
		else if(this.employeeUserDao.existsEmployeeUserByEmail(employeeUser.getEmail())) {
			return new ErrorResult("E mail sistemde zaten kayıtlı");
		}
		else if(!employeeUser.getPassword().equals(passwordRepeat)) {
			return new ErrorResult("Şifre tekrarı yanlış");
		}
		else if (this.employeeUserDao.existsEmployeeUserByIdentityNo(employeeUser.getIdentityNo())) { 
			return new ErrorResult("Bu kimlik numaralı bir kayıt mevcuttur.");	
		}
		else {
			this.employeeUserDao.save(employeeUser);
			return new SuccessResult("Başarıyla kayıt olundu!");
		}
		
	}
	
	@Override
	public DataResult<List<EmployeeUser>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<EmployeeUser>>(this.employeeUserDao.findAll(), "İş Arayanlar Listelendi");
	}
	
	
	
	public boolean hasEmptField(EmployeeUser employeeUser) {
		if (employeeUser.getFirstName().isEmpty() 
				|| employeeUser.getLastName().isEmpty() 
				|| employeeUser.getBirthYear().isEmpty() 
				|| employeeUser.getEmail().isEmpty() 
				|| employeeUser.getIdentityNo().toString().isEmpty() 
				|| employeeUser.getPassword().isEmpty() ) {
			return true;
		} 
		else {
			return false;
		}
	}



	

}
