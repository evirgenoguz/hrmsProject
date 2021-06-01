package com.example.hrmsProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hrmsProject.business.abstracts.JobPositionService;
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
	public List<JobPosition> getAll() {
		// TODO Auto-generated method stub
		return this.jobPositionDao.findAll();
	}

}
