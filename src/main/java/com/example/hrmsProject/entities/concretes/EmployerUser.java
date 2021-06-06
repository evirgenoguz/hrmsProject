package com.example.hrmsProject.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name = "id")
@Table(name = "employer_users")
public class EmployerUser extends User {
	
	@Column(name = "company_name")
	private String companyName;
	
	@Column(name = "web_adress")
	private String WebAdress;
	
	@Column(name = "phone_number")
	private String phoneNumber;
}
