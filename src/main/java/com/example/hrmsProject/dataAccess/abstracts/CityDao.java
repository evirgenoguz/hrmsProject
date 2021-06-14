package com.example.hrmsProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hrmsProject.entities.concretes.City;

public interface CityDao extends JpaRepository<City, Integer>{

}
