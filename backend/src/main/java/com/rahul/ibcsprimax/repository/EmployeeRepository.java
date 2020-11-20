package com.rahul.ibcsprimax.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rahul.ibcsprimax.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	
	
	@Query("Select e from Employee e inner join e.grade eg  inner join Payscale p on eg.id = p.grade.id")
	List<Employee> findEmployeeSalary();

}
