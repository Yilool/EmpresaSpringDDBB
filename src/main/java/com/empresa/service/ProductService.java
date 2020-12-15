package com.empresa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.entity.Product;
import com.empresa.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository pr;

	public Product crearProduct(Product p) {
		pr.save(p);

		return p;
	}

	public Iterable<Product> obtenerProducts() {
		return pr.findAll();
	}

	public Product obtenerProduct(Integer id) {
		return pr.findProductById(id);
	}

	public Product actualizarProduct(Product p) {
		Product p1 = pr.findProductById(p.getId());
		p1.setPrdName(p.getPrdName());
		p1.setPrdPrice(p.getPrdPrice());
		return pr.save(p1);
	}

	public void borrarProduct(Integer id) {
		pr.deleteById(id);
	}
}

