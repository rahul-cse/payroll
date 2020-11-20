package com.rahul.ibcsprimax.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.rahul.ibcsprimax.enums.GradeEnum;


@Entity
public class Grade {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private GradeEnum gradeEnum; //superiority
	

	public Grade() {
		super();
	}
	
	public Grade(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public GradeEnum getGradeEnum() {
		return gradeEnum;
	}

	public void setGradeEnum(GradeEnum gradeEnum) {
		this.gradeEnum = gradeEnum;
	}

	
	
	
}
