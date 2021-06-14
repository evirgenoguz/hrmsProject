package com.example.hrmsProject.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@Table(name = "job_advertisements")
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisement {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "company")
	private String company;
	
	@Column(name = "job_description")
	private String jobDescription;
	
	@Column(name = "salary")
	private int Salary;
	
	@Column(name = "create_date")
	private Date createDate;
	
	@Column(name = "dead_line")
	private Date deadLine;
	
	@Column(name = "active")
	private boolean active;
	
	@Column(name = "number_of_position")
	private int numberOfPosition;
	
	
	@ManyToOne
	@JoinColumn(name = "job_position_id")
	private JobPosition jobPosition;
	
	@ManyToOne
	@JoinColumn(name="city_id")
	private City city;
	
	
	@ManyToOne
	@JoinColumn(name = "employer_user_id")
	private EmployerUser employerUser;
}
