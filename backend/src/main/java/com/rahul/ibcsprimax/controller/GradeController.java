package com.rahul.ibcsprimax.controller;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

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

import com.rahul.ibcsprimax.entity.Employee;
import com.rahul.ibcsprimax.entity.Grade;
import com.rahul.ibcsprimax.enums.GradeEnum;
import com.rahul.ibcsprimax.service.GradeService;

@CrossOrigin("*")
@RestController
@RequestMapping("/grade")
public class GradeController {
	
	@Autowired
	GradeService gradeService;

	@GetMapping("/")
	public List<Grade> getAllGrades(){
		return gradeService.getAll();
	}
	
	@GetMapping("/{id}")
	public Grade getGrade(@PathVariable Integer id) {
		return gradeService.getById(id);
	}
	
	@PostMapping("/create")
	public ResponseEntity<?> saveGrade(@RequestBody @Valid Grade grade) {
		gradeService.save(grade);
		return  ResponseEntity.ok(HttpStatus.CREATED);
		
	}
	
	@PutMapping("/update")
	public ResponseEntity updateGrade(@RequestBody @Valid Grade grade) {
		gradeService.save(grade);
		return ResponseEntity.ok("Updated");
		
	}
	
	@DeleteMapping("/delete")
	public void deleteGrade() {
		
	}
	
	@GetMapping("/lowest")
	public Grade getLowestGrade() {
		return gradeService.getLowetGrade(GradeEnum.Six);
	}
	
	@GetMapping("/gradeTypes")
	public List<GradeEnum> getGradeEnum() {
		return Arrays.asList(GradeEnum.values());
	}
}
