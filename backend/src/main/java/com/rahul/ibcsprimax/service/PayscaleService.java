package com.rahul.ibcsprimax.service;

import java.util.List;

import com.rahul.ibcsprimax.entity.Payscale;

public interface PayscaleService {

	public void save(Payscale payscale);
	
	public boolean saveAll(List<Payscale> payscaleList);
	
	public List<Payscale> getAll();
	
	public List<Payscale> calculateOtherPayscale(Payscale payscale);
}
