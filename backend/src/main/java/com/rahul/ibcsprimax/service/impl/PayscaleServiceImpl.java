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
	public Payscale save(Payscale payscale) {
		calculateAllowance(payscale,payscale.getBasic());
		payscaleRepository.save(payscale);
		return payscale;
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
			calculateAllowance(newPayscale, basic);
			newPayscale.setName(grade.getName());
			payscaleList.add(newPayscale);
		}
		return payscaleList;
	}
	
	public void calculateAllowance(Payscale payscale, Double basic) {
		payscale.setHouseRent(basic*.20);
		payscale.setMedicalAllowance(basic*.15);
	}


	@Override
	public Payscale getById(Long id) {
		return payscaleRepository.findById(id).get();
	}


	@Override
	public Payscale update(Payscale payscale) {
		calculateAllowance(payscale, payscale.getBasic());
		if(payscale.getGrade().getGradeEnum().equals(GradeEnum.Six)) {
			 List<Payscale> payscaleList=calculateOtherPayscale(payscale);
			 payscaleList.add(payscale);
			 payscaleRepository.saveAll(payscaleList);
		}
		else {
			payscaleRepository.save(payscale);
		}
		return payscale;
	}


	@Override
	public Payscale findByGrade(Grade grade) {
		return payscaleRepository.findByGrade(grade);
	}




}
