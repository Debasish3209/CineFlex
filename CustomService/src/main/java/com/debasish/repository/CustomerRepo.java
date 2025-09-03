package com.debasish.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.debasish.model.Customer;

public interface CustomerRepo extends JpaRepository<Customer, String>  {

}
