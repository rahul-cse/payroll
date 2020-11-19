package com.rahul.ibcsprimax.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

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
}
