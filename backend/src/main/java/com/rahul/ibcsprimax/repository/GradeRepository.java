package com.rahul.ibcsprimax.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rahul.ibcsprimax.entity.Grade;
import com.rahul.ibcsprimax.enums.GradeEnum;

public interface GradeRepository extends JpaRepository<Grade, Integer>{

	Grade findByGradeEnum(GradeEnum gradeEnum);
}
