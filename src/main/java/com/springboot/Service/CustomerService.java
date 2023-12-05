package com.springboot.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.Exception.CustomerNotFoundException;
import com.springboot.Model.Customer;
import com.springboot.Repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository customerRepository;
	
	List<Customer> customer = new ArrayList<>();

	
	public List<Customer> getAllCustomer()
	{
		return customerRepository.findAll();
	}
	
	public Customer addCustomer(Customer newCustomer )
	{
		return customerRepository.save(newCustomer);
	}
	
	public List<Customer> deleteCustomer(int id)
	{
		Optional<Customer> customerToDelete = customerRepository.findById(id);
		
		if(customerToDelete.isPresent())
		{
			customer.remove(customerToDelete.get());
			customerRepository.deleteById(id);
		}
		return customer;
		
	}
	
	public List<Customer> updateCustomer(Integer id, Customer updatedCustomer)
	{
		if(!customerRepository.existsById(id)) throw new CustomerNotFoundException();
		 Customer existingCustomer = customerRepository.findById(id).orElse(null);
		 
		    if (existingCustomer!=null) {
		    existingCustomer.setCustomerId(updatedCustomer.getCustomerId());
		    existingCustomer.setCustomerName(updatedCustomer.getCustomerName());
		    existingCustomer.setCustomerBudget(updatedCustomer.getCustomerBudget());
		        customerRepository.save(existingCustomer);
		    }
		    return customer;
		    }
		    
}
