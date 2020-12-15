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

import com.empresa.entity.Employee;
import com.empresa.service.EmployeeService;

@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE})
@RestController
@RequestMapping(path = "/empresa")
public class EmployeeController {
	@Autowired
	private EmployeeService es; 

	@PostMapping(path = "/employee")
	public ResponseEntity<?> postEmployee(@RequestBody Employee employee) {
		return ResponseEntity.status(HttpStatus.OK).body(es.crearEmployee(employee));
	}

	@GetMapping(path = "/employee")
	public ResponseEntity<?> getAllEmployee() {
		return ResponseEntity.status(HttpStatus.OK).body(es.obtenerEmployees());
	}

	@GetMapping(path = "/employee/{id}")
	public ResponseEntity<?> getEmployee(@PathVariable int id) {
		return ResponseEntity.status(HttpStatus.OK).body(es.obtenerEmployee(id));
	}

	@PutMapping(path = "/employee")
	public ResponseEntity<?> putEmployee(@RequestBody Employee employee) {
		return ResponseEntity.status(HttpStatus.OK).body(es.actualizarBiblioteca(employee));
	}

	@DeleteMapping(path = "/employee/{id}")
	public ResponseEntity<?> delProduct(@PathVariable int id) {
		es.borrarEmployee(id);
		
		return ResponseEntity.status(HttpStatus.OK).body("Borrado");
	}
}
