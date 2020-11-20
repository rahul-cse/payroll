package com.rahul.ibcsprimax.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rahul.ibcsprimax.entity.Grade;
import com.rahul.ibcsprimax.entity.Payscale;
import com.rahul.ibcsprimax.enums.GradeEnum;

public interface PayscaleRepository extends JpaRepository<Payscale, Long>{

	Payscale findByGradeGradeEnum(GradeEnum gradeEnum);
	
	Payscale findByGrade(Grade grade);
}
