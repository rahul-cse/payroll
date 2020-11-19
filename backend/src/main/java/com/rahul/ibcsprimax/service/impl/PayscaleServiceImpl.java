package com.rahul.ibcsprimax.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rahul.ibcsprimax.entity.Grade;
import com.rahul.ibcsprimax.entity.Payscale;
import com.rahul.ibcsprimax.enums.GradeEnum;
import com.rahul.ibcsprimax.repository.GradeRepository;
import com.rahul.ibcsprimax.repository.PayscaleRepository;
import com.rahul.ibcsprimax.service.PayscaleService;

@Service
public class PayscaleServiceImpl implements PayscaleService{
	
	@Autowired
	PayscaleRepository payscaleRepository;
	@Autowired
	GradeRepository gradeRepository;

	@Override
	public void save(Payscale payscale) {
		payscaleRepository.save(payscale);		
	}
	

	@Override
	public boolean saveAll(List<Payscale> payscaleList) {
		payscaleRepository.saveAll(payscaleList);
		return true;
	}

	@Override
	public List<Payscale> getAll() {
		return payscaleRepository.findAll();
	}

	@Override
	public List<Payscale> calculateOtherPayscale(Payscale payscale) {
		List<Grade> gradeList = gradeRepository.findByGradeEnumNotOrderByGradeEnumDesc(GradeEnum.Six);
		List<Payscale> payscaleList = new ArrayList<Payscale>();
		int order = payscale.getGrade().getGradeEnum().ordinal();
		Double basic = payscale.getBasic();
		for(Grade grade: gradeList) {
			Payscale newPayscale = null;
			Payscale prevPayscale = payscaleRepository.findByGradeGradeEnum(grade.getGradeEnum());
			if(prevPayscale!=null)
				newPayscale = prevPayscale;
			else
				newPayscale = new Payscale();
			
			newPayscale.setGrade(grade);
			basic+=5000;
			newPayscale.setBasic(basic);
			newPayscale.setHouseRent(basic*.20);
			newPayscale.setMedicalAllowance(basic*.15);
			newPayscale.setName(grade.getName());
			payscaleList.add(newPayscale);
		}
		return payscaleList;
	}




}
