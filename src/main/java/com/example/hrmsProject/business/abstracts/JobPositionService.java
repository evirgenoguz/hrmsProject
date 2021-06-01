package com.example.hrmsProject.business.abstracts;

import java.util.List;

import com.example.hrmsProject.entities.concretes.JobPosition;

public interface JobPositionService {
	List<JobPosition> getAll();
}
