package com.rahul.ibcsprimax.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Payscale {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	private Double basic;
	private Double houseRent;
	private Double medicalAllowance;
	
	@OneToOne
	@JoinColumn(nullable=false)
	private Grade grade;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getBasic() {
		return basic;
	}

	public void setBasic(Double basic) {
		this.basic = basic;
	}

	public Double getHouseRent() {
		return houseRent;
	}

	public void setHouseRent(Double houseRent) {
		this.houseRent = houseRent;
	}

	public Double getMedicalAllowance() {
		return medicalAllowance;
	}

	public void setMedicalAllowance(Double medicalAllowance) {
		this.medicalAllowance = medicalAllowance;
	}

	public Grade getGrade() {
		return grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}
	
	
}
