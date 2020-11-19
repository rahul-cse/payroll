package com.rahul.ibcsprimax.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rahul.ibcsprimax.entity.Payscale;
import com.rahul.ibcsprimax.repository.PayscaleRepository;
import com.rahul.ibcsprimax.service.PayscaleService;

@Service
public class PayscaleServiceImpl implements PayscaleService{
	
	@Autowired
	PayscaleRepository payscaleRepository;

	@Override
	public void save() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Payscale> getAll() {
		return payscaleRepository.findAll();
	}

}
