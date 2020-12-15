package com.empresa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "Customers")
public class Customer implements Comparable<Customer>, Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "CusName")
	private String cusName;
	@Column(name = "CusSurname")
	private String cusSurname;
	
	public Customer() {
	}
	
	public Customer(String name, String surname) {
		this.cusName = name;
		this.cusSurname = surname;
	}

	public String getCusName() {
		return cusName;
	}

	public void setCusName(String cusName) {
		this.cusName = cusName;
	}

	public String getCusSurname() {
		return cusSurname;
	}

	public void setCusSurname(String cusSurname) {
		this.cusSurname = cusSurname;
	}

	public Integer getId() {
		return id;
	}
	
	@Override
	public int compareTo(Customer other) {
		return Integer.valueOf(this.id).compareTo(other.getId());
	}
}
