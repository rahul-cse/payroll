package com.rahul.ibcsprimax.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rahul.ibcsprimax.entity.Grade;
import com.rahul.ibcsprimax.enums.GradeEnum;
import com.rahul.ibcsprimax.repository.GradeRepository;
import com.rahul.ibcsprimax.service.GradeService;

@Service
public class GradeServiceImpl implements GradeService {
	
	@Autowired
	GradeRepository gradeRepository;

	@Override
	public void save(Grade grade) {
		gradeRepository.save(grade);
		
	}

	@Override
	public Grade getById(Integer id) {
		Optional<Grade> gradeOpt = gradeRepository.findById(id);
		return gradeOpt.isPresent()?gradeOpt.get():null;
	}

	@Override
	public List<Grade> getAll() {
		return gradeRepository.findAll();
	}

	@Override
	public void update(Grade grade) {
		gradeRepository.save(grade);		
	}

	@Override
	public void delete(Integer id) {
		gradeRepository.deleteById(id);		
	}

	@Override
	public Grade getLowetGrade(GradeEnum gradeEnum) {
		return gradeRepository.findByGradeEnum(gradeEnum);
	}

}
