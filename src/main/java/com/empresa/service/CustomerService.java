package com.empresa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.entity.Customer;
import com.empresa.repository.CustomerRepository;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepository cr;

	public Customer crearCustomer(Customer c) {
		cr.save(c);

		return c;
	}

	public Iterable<Customer> obtenerCustomers() {
		return cr.findAll();
	}

	public Customer obtenerCustomer(Integer id) {
		return cr.findCustomerById(id);
	}

	public Customer actualizarCustomer(Customer c) {
		Customer c1 = cr.findCustomerById(c.getId());
		c1.setCusName(c.getCusName());
		c1.setCusSurname(c.getCusSurname());
		return cr.save(c1);
	}


	public void borrarCustomer(Integer id) {
		cr.deleteById(id);
	}
}
