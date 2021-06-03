package com.example.hrmsProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hrmsProject.business.abstracts.JobPositionService;
import com.example.hrmsProject.core.utilities.results.DataResult;
import com.example.hrmsProject.core.utilities.results.ErrorResult;
import com.example.hrmsProject.core.utilities.results.Result;
import com.example.hrmsProject.core.utilities.results.SuccessDataResult;
import com.example.hrmsProject.core.utilities.results.SuccessResult;
import com.example.hrmsProject.dataAccess.abstracts.JobPositionDao;
import com.example.hrmsProject.entities.concretes.JobPosition;




@Service
public class JobPositionManager implements JobPositionService{

	private JobPositionDao jobPositionDao;
	
	@Autowired
	public JobPositionManager(JobPositionDao jobPositionDao) {
		super();
		this.jobPositionDao = jobPositionDao;
	}


	@Override
	public DataResult<List<JobPosition>> getAll() {
		
		return new SuccessDataResult<List<JobPosition>>(this.jobPositionDao.findAll(), "İşler Listelendi");
	
	}


	@Override
	public Result add(JobPosition jobPosition) {
		
		if (this.jobPositionDao.getByPositionName(jobPosition.getPositionName()) != null) {
			return new ErrorResult("Aynı Pozisyon Tekrar Edemez");
		}
		else {
			this.jobPositionDao.save(jobPosition);
			return new SuccessResult("Ürün Eklendi");
		}
		
	}

}
