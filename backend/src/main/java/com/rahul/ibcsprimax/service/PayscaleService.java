package com.rahul.ibcsprimax.service;

import java.util.List;

import com.rahul.ibcsprimax.entity.Grade;
import com.rahul.ibcsprimax.entity.Payscale;

public interface PayscaleService {

	public Payscale save(Payscale payscale);
	
	public boolean saveAll(List<Payscale> payscaleList);
	
	public Payscale update(Payscale payscale);
	
	public List<Payscale> getAll();
	
	public List<Payscale> calculateOtherPayscale(Payscale payscale);

	public Payscale getById(Long id);
	
	public Payscale findByGrade(Grade grade);
}
