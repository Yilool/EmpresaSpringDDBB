package com.empresa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "Products")
public class Product implements Comparable<Product>, Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "PrdName")
	private String prdName;
	@Column(name = "PrdPrice")
	private double prdPrice;
	
	public Product() {
	}
	
	public Product(String name, double price) {
		this.prdName = name;
		this.prdPrice = price;
	}

	public String getPrdName() {
		return prdName;
	}

	public void setPrdName(String prdName) {
		this.prdName = prdName;
	}

	public double getPrdPrice() {
		return prdPrice;
	}

	public void setPrdPrice(double prdPrice) {
		this.prdPrice = prdPrice;
	}

	public Integer getId() {
		return id;
	}

	@Override
	public int compareTo(Product other) {
		return Integer.valueOf(this.id).compareTo(other.getId());
	}
}
