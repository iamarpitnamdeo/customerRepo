package com.springboot.Controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.springboot.Model.Customer;
import com.springboot.Service.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	@Autowired
	RestTemplate restTemplate;
	
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
	

	  @GetMapping("/template/product")
	    public String getProductList() {
	        HttpHeaders headers = new HttpHeaders();
	        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	        HttpEntity<String> entity = new HttpEntity<>(headers);

	        return restTemplate.exchange("http://localhost:8082/product", HttpMethod.GET, entity, String.class).getBody();
	    }
	  
//	  @RequestMapping(value = "/template/product", method = RequestMethod.POST)
//	   public String createProducts(@RequestBody Product product) {
//	      HttpHeaders headers = new HttpHeaders();
//	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//	      HttpEntity<Product> entity = new HttpEntity<Product>(product,headers);
//	      
//	      return restTemplate.exchange(
//	         "http://localhost:8082/product", HttpMethod.POST, entity, String.class).getBody();
//	   }
//	  
//
//	   @RequestMapping(value = "/template/product/{id}", method = RequestMethod.PUT)
//	   public String updateProduct(@PathVariable("id") int id, @RequestBody Product product) {
//	      HttpHeaders headers = new HttpHeaders();
//	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//	      HttpEntity<Product> entity = new HttpEntity<Product>(product,headers);
//	      
//	      return restTemplate.exchange(
//	         "http://localhost:8082/product/"+id, HttpMethod.PUT, entity, String.class).getBody();
//	   }
//	   
//
//	   @RequestMapping(value = "/template/product/{id}", method = RequestMethod.DELETE)
//	   public String deleteProduct(@PathVariable("id") int id) {
//	      HttpHeaders headers = new HttpHeaders();
//	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//	      HttpEntity<Product> entity = new HttpEntity<Product>(headers);
//	      
//	      return restTemplate.exchange(
//	         "http://localhost:8082/product/"+id, HttpMethod.DELETE, entity, String.class).getBody();
//	   }
//	   
}
