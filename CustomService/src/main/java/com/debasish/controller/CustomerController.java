package com.debasish.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.debasish.dto.CustomerDto;
import com.debasish.model.Customer;
import com.debasish.service.CustomerService;
import com.debasish.util.ResponseStructure;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/customers")
public class CustomerController {

	private CustomerService customerService;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Customer>>saveCustomer(@RequestBody CustomerDto customerDto){
	return customerService.saveCustomer(customerDto);
}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<List<Customer>>> findAllCustomers() {
	    return customerService.findAllCustomers();
	}
	
	@PutMapping("/{custId}")
	public ResponseEntity<ResponseStructure<Customer>>updateBycustId(@PathVariable("custId")String custId, @RequestBody CustomerDto customerDto){
		return customerService.updateByCustomerId(custId, customerDto);
	}
	@DeleteMapping("/{custId}")
	public ResponseEntity<ResponseStructure<Customer>>deleteByCustomerId(@PathVariable("custId")String custId){
		return customerService.deleteByCustomerId(custId);
	}


}
