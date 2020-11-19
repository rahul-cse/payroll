package com.rahul.ibcsprimax.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rahul.ibcsprimax.entity.Payscale;
import com.rahul.ibcsprimax.service.PayscaleService;

@CrossOrigin("*")
@RestController
@RequestMapping("/payscale")
public class PayscaleController {
	
	@Autowired
	PayscaleService payscaleService;

	@GetMapping("/")
	public List<Payscale> getAllPayscale(){
		return payscaleService.getAll();
		
	}
	
	@PostMapping()
	public ResponseEntity<?> saveLowerGradePayscale(@RequestBody Payscale payscale) {
		return  ResponseEntity.ok(HttpStatus.CREATED);
	}
	
}
