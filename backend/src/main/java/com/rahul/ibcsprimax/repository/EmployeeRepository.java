package com.rahul.ibcsprimax.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rahul.ibcsprimax.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
