package com.rahul.ibcsprimax.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;

@Entity
public class SalaryTransaction {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@OneToOne(cascade = CascadeType.REFRESH)
	private Employee employee;
	private Double totalSalary;
	@OneToOne(cascade = CascadeType.REFRESH)
	private Payscale payscale;
	private Date date;
	
	@PrePersist
	public void savedate(){
		setDate(new Date());
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public Double getTotalSalary() {
		return totalSalary;
	}
	public void setTotalSalary(Double totalSalary) {
		this.totalSalary = totalSalary;
	}
	public Payscale getPayscale() {
		return payscale;
	}
	public void setPayscale(Payscale payscale) {
		this.payscale = payscale;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
	
}
