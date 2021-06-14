package com.example.hrmsProject.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hrmsProject.entities.concretes.JobAdvertisement;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer>{
	
	List<JobAdvertisement> getByJobPosition_PositionName(String jobPositionName);
	
	List<JobAdvertisement> getByCity_CityName(String cityName);
	
	//List<JobAdvertisement> getBySalaryBetween(Integer minSalary, Integer maxSalary);
}
