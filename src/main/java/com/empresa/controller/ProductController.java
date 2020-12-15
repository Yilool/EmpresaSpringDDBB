package com.empresa.controller;

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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.entity.Product;
import com.empresa.service.ProductService;

@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE})
@RestController
@RequestMapping(path = "/empresa")
public class ProductController {
	@Autowired
	private ProductService pr;

	@PostMapping(path = "/product")
	public ResponseEntity<?> postProduct(@RequestBody Product product) {
		return ResponseEntity.status(HttpStatus.OK).body(pr.crearProduct(product));
	}

	@GetMapping(path = "/product")
	public ResponseEntity<?> getAllProduct() {
		return ResponseEntity.status(HttpStatus.OK).body(pr.obtenerProducts());
	}

	@GetMapping(path = "/product/{id}")
	public ResponseEntity<?> getProduct(@PathVariable int id) {
		return ResponseEntity.status(HttpStatus.OK).body(pr.obtenerProduct(id));
	}

	@PutMapping(path = "/product")
	public ResponseEntity<?> putProduct(@RequestBody Product product) {
		return ResponseEntity.status(HttpStatus.OK).body(pr.actualizarProduct(product));
	}

	@DeleteMapping(path = "/product/{id}")
	public ResponseEntity<?> delProduct(@PathVariable int id) {
		pr.borrarProduct(id);
		
		return ResponseEntity.status(HttpStatus.OK).body("Borrado");
	}
}
