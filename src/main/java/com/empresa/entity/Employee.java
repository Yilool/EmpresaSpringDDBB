package com.empresa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "Employees")
public class Employee implements Comparable<Employee>, Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "EmpName")
	private String empName;
	@Column(name = "EmpSurname")
	private String empSurname;
	
	public Employee() {
	}
	
	public Employee(String name, String surname) {
		this.empName = name;
		this.empSurname = surname;
	}
	
	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpSurname() {
		return empSurname;
	}

	public void setEmpSurname(String empSurname) {
		this.empSurname = empSurname;
	}

	public Integer getId() {
		return id;
	}
	
	@Override
	public int compareTo(Employee other) {
		return Integer.valueOf(this.id).compareTo(other.getId());
	}
}
