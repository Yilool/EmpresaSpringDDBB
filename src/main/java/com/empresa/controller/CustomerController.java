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

import com.empresa.entity.Customer;
import com.empresa.service.CustomerService;

@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE})
@RestController
@RequestMapping(path = "/empresa")
public class CustomerController {
	@Autowired
	private CustomerService cs; 

	@PostMapping(path = "/custom")
	public ResponseEntity<?> postCustom(@RequestBody Customer custom) {
		return ResponseEntity.status(HttpStatus.OK).body(cs.crearCustomer(custom));
	}

	@GetMapping(path = "/custom")
	public ResponseEntity<?> getAllCustom() {
		return ResponseEntity.status(HttpStatus.OK).body(cs.obtenerCustomers());
	}

	@GetMapping(path = "/custom/{id}")
	public ResponseEntity<?> getCustom(@PathVariable int id) {
		return ResponseEntity.status(HttpStatus.OK).body(cs.obtenerCustomer(id));
	}

	@PutMapping(path = "/custom")
	public ResponseEntity<?> putCustom(@RequestBody Customer custom) {
		return ResponseEntity.status(HttpStatus.OK).body(cs.actualizarCustomer(custom));
	}

	@DeleteMapping(path = "/custom/{id}")
	public ResponseEntity<?> delCustom(@PathVariable int id) {
		cs.borrarCustomer(id);
		
		return ResponseEntity.status(HttpStatus.OK).body("Borrado");
	}
}
