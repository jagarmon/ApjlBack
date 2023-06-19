package com.apjl.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apjl.dao.CustomersDAO;
import com.apjl.model.Customers;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("clientes")
public class CustomersRest {

	@Autowired
	private CustomersDAO customerDAO;
	
	@PostMapping("/nuevo")
	public void saveCustomer(@RequestBody Customers customer) {
		customerDAO.save(customer);
	}
	
	@GetMapping("/listar")
	public List<Customers> listCustomers(){
		return customerDAO.findAll();
	}
	
	@DeleteMapping("/eliminar/{id}")
	public void deleteCustomer(@PathVariable("id") Integer id) {
		customerDAO.deleteById(id);
	}
}
