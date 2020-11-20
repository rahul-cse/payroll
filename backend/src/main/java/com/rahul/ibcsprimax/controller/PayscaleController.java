package com.rahul.ibcsprimax.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@GetMapping("/{strId}")
	public Payscale getPayscale(@PathVariable String strId) throws Exception {
		Long id = null;
		try {
			id = Long.parseLong(strId);
		}
		catch(Exception ex) {
			throw ex;
		}
		return payscaleService.getById(id);
	}
	
	@PostMapping("/create")
	public ResponseEntity<?> saveLowerGradePayscale(@RequestBody Payscale payscale) {
		payscale = payscaleService.save(payscale);
		List<Payscale> payscaleList= payscaleService.calculateOtherPayscale(payscale);
		payscaleService.saveAll(payscaleList);
		return  ResponseEntity.ok(HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> updatePayscale(@RequestBody Payscale payscale) {
		payscaleService.update(payscale);
		return  ResponseEntity.ok(HttpStatus.OK); 
	}
	
	@DeleteMapping("/delete/{id}")
	public void deletePayscale() {
		//payscaleService
	}
	
}
