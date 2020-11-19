package com.rahul.ibcsprimax.service;

import java.util.List;

import com.rahul.ibcsprimax.entity.Grade;
import com.rahul.ibcsprimax.enums.GradeEnum;

public interface GradeService {

public void save(Grade grade);
	
	public void update(Grade grade);
	
	public Grade getById(Integer id);
	
	public List<Grade> getAll();
	
	public void delete(Integer id);
	
	public Grade getLowetGrade(GradeEnum gradeEnum);
}
