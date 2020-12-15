package com.empresa.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.empresa.entity.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer>{
	
    public Product findProductById(Integer id);
}