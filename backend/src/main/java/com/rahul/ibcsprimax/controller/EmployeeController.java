package com.rahul.ibcsprimax.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rahul.ibcsprimax.entity.Employee;
import com.rahul.ibcsprimax.service.EmployeeService;

@CrossOrigin("*")
@RestController
@RequestMapping("/emp")
@Transactional
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;

	@GetMapping("")
	public List<Employee> getAllEmployees() {
		return employeeService.getAll();
	}
	
	@GetMapping("/{strId}")
	public Employee getEmployee(@PathVariable String strId) throws Exception {
		Long id = null;
		try {
			id = Long.parseLong(strId);
		}
		catch(Exception ex) {
			throw new Exception();
		}	
		return employeeService.getById(id);
	}
	
	
	@PostMapping("/create")
	public ResponseEntity<?> saveEmployee(@RequestBody @Valid Employee employee) {
		employeeService.save(employee); 
		return ResponseEntity.ok(HttpStatus.CREATED);
		
	}
	@PutMapping("/update")
	public ResponseEntity<?> updateEmployee(@RequestBody @Valid Employee employee){
		employeeService.update(employee); 
		return ResponseEntity.ok(HttpStatus.OK);
	}
	

}
