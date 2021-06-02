 package com.example.hrmsProject.core.utilities.adapters.concretes;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.example.hrmsProject.core.utilities.adapters.abstracts.MernisService;
import com.example.hrmsProject.entities.concretes.EmployeeUser;

import tr.gov.nvi.tckimlik.WS.KPSPublicSoap;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

@Primary
@Component
public class MernisManager implements MernisService{

	@Override
	public Boolean checkIfEmployeeUserRealPerson(EmployeeUser employeeUser) {
		KPSPublicSoap client = new KPSPublicSoapProxy();
		
		boolean result = false;
		
		try {
			result = client.TCKimlikNoDogrula(Long.parseLong(employeeUser.getIdentityNo()), 
					employeeUser.getFirstName().toUpperCase(), 
					employeeUser.getLastName().toUpperCase(), 
					Integer.parseInt(employeeUser.getBirthYear()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
}
