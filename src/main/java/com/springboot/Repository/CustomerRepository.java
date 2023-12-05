package com.springboot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.Model.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Integer>{

}
