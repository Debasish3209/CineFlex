package com.debasish.serviceImpl;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.debasish.dto.CustomerDto;
import com.debasish.exception.CustomerNotDeletedException;
import com.debasish.exception.CustomerNotFoundByIdException;
import com.debasish.model.Customer;
import com.debasish.repository.CustomerRepo;
import com.debasish.service.CustomerService;
import com.debasish.util.ResponseStructure;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final ResponseStructure responseStructure;

    private final CustomerRepo customerRepo;

    // Constructor Injection
    public CustomerServiceImpl(CustomerRepo customerRepo, ResponseStructure responseStructure) {
        this.customerRepo = customerRepo;
        this.responseStructure = responseStructure;
    }

    @Override
	public ResponseEntity<ResponseStructure<Customer>> saveCustomer(CustomerDto customerDto) {	

		return ResponseEntity.ok(responseStructure.setStatuscode(HttpStatus.OK.value())
				.setMessage("Customer Data Saved Successfully!")
				.setData(customerRepo.save(mapToCustomer(customerDto))));
	}
    private Customer mapToCustomer(CustomerDto customerDto) {
		// TODO Auto-generated method stub

		String randomCustId = UUID.randomUUID().toString(); //for generating unique custId;
		return  Customer.builder()
				.custName(customerDto.getCustName())
				.custEmail(customerDto.getCustEmail())
				.custPh(customerDto.getCustPh())
				.custAddress(customerDto.getCustAddress())
				.custId(randomCustId).build();
	}


    
    @Override
    public ResponseEntity<ResponseStructure<Customer>> findByCustomerId(String custId) {
        // Example implementation (you’ll need to handle Optional properly)
        Customer customer = customerRepo.findById(custId).orElse(null);

        ResponseStructure<Customer> response = new ResponseStructure<>();
        if (customer != null) {
            response.setStatuscode(200);
            response.setMessage("Customer found");
            response.setData(customer);
            return ResponseEntity.ok(response);
        } else {
            response.setStatuscode(404);
            response.setMessage("Customer not found");
            response.setData(null);
            return ResponseEntity.status(404).body(response);
        }
    }

    @Override
    public ResponseEntity<ResponseStructure<Customer>> updateByCustomerId(String custId, CustomerDto customerDto) {
        Customer updateCustomer = mapToCustomer(customerDto);

        return customerRepo.findById(custId).map(exCust -> {
            updateCustomer.setCustId(exCust.getCustId());
            Customer savedCustomer = customerRepo.save(updateCustomer);

            ResponseStructure<Customer> response = new ResponseStructure<>();
            response.setStatuscode(HttpStatus.OK.value());
            response.setMessage("Customer data updated successfully");
            response.setData(savedCustomer);

            return ResponseEntity.ok(response);
        }).orElseThrow(() -> new CustomerNotFoundByIdException("Customer not found"));
    }


    @Override
    public ResponseEntity<ResponseStructure<Customer>> deleteByCustomerId(String custId) {
        return customerRepo.findById(custId).map(customer -> {
            customerRepo.delete(customer);

            ResponseStructure<Customer> response = new ResponseStructure<>();
            response.setStatuscode(HttpStatus.OK.value());
            response.setMessage("Customer data deleted successfully");
            response.setData(customer); // optional: return deleted customer info

            return ResponseEntity.ok(response);
        }).orElseThrow(() -> new CustomerNotDeletedException("Customer Not Deleted, try again!"));
    }


    @Override
    public ResponseEntity<ResponseStructure<List<Customer>>> findAllCustomers() {
        List<Customer> customers = customerRepo.findAll();

        ResponseStructure<List<Customer>> response = new ResponseStructure<>();
        response.setStatuscode(200);
        response.setMessage("All customers fetched successfully");
        response.setData(customers);

        return ResponseEntity.ok(response);
    }
}
