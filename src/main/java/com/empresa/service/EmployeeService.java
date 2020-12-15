package com.empresa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.entity.Employee;
import com.empresa.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository er;

	public Employee crearEmployee(Employee e) {
		er.save(e);

		return e;
	}

	public Iterable<Employee> obtenerEmployees() {
		return er.findAll();
	}

	public Employee obtenerEmployee(Integer id) {
		return er.findEmployeeyById(id);
	}

	public Employee actualizarBiblioteca(Employee e) {
		Employee e1 = er.findEmployeeyById(e.getId());
		e1.setEmpName(e.getEmpName());
		e1.setEmpSurname(e.getEmpSurname());
		return er.save(e1);
	}

	public void borrarEmployee(Integer id) {
		er.deleteById(id);
	}
}
