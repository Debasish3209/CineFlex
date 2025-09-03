package com.debasish.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.debasish.dto.CustomerDto;
import com.debasish.model.Customer;
import com.debasish.util.ResponseStructure;

public interface CustomerService {

	public ResponseEntity<ResponseStructure<Customer>> saveCustomer(CustomerDto customerDto);
	
	public ResponseEntity<ResponseStructure<Customer>> findByCustomerId(String custId);
	
	public ResponseEntity<ResponseStructure<Customer>> updateByCustomerId(String custId, CustomerDto customerDto);

	public ResponseEntity<ResponseStructure<Customer>> deleteByCustomerId(String custId);
	
	public ResponseEntity<ResponseStructure<List<Customer>>> findAllCustomers();
}
