package com.tgdd.service.impl;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.tgdd.dto.CustomerDto;
import com.tgdd.entity.Customer;
import com.tgdd.repository.CustomerRepository;
import com.tgdd.service.CustomerService;

public class CustomerServiceImpl implements CustomerService{
	
	@Autowired 
	CustomerRepository customerRepository;
	
	@Autowired
	ModelMapper modelMapper;

	@Override
	public ResponseEntity<?> addCustomer(CustomerDto customerDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> getOrdersbyPhoneNumber(Long phoneNumber) {
		Optional<Customer> optional = customerRepository.findById(phoneNumber);
		if(!optional.isPresent()) {
			
		}
		return null;
	}

	@Override
	public Customer getCustomerByPhoneNumber(Long phoneNumber) {
		// TODO Auto-generated method stub
		return null;
	}

}
