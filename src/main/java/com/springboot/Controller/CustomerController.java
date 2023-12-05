package com.springboot.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.Model.Customer;
import com.springboot.Service.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@GetMapping(value="/customer")
	public ResponseEntity<List<Customer>> getCustomers(){
		
		return new ResponseEntity<>(customerService.getAllCustomer(),HttpStatus.OK);
	}
	
	
	@PostMapping(value="/customer")
	public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer){	
		return new ResponseEntity<>(customerService.addCustomer(customer),HttpStatus.CREATED);
	}
	
	@DeleteMapping(value="/customer/{id}")
	public ResponseEntity<List<Customer>> deleteCustomer(@PathVariable int id){ 
		return new ResponseEntity<>(customerService.deleteCustomer(id),HttpStatus.OK);
	}
	
	
	@PutMapping(value="/customer/{id}")
	public ResponseEntity<List<Customer>> updateCustomer(@PathVariable("id") int id, @RequestBody Customer customer){
		return new ResponseEntity<>(customerService.updateCustomer(id, customer),HttpStatus.OK);
		
	}
}
