package com.tgdd.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tgdd.dto.CustomerDto;
import com.tgdd.entity.Cart;
import com.tgdd.entity.Customer;

@Service
public interface CustomerService {
	
	public CustomerDto addCustomer(CustomerDto customerDto);
	
	public ResponseEntity<?> getOrdersbyPhoneNumber(Long phoneNuber);
	
	public Customer getCustomerByPhoneNumber(Long phoneNumber);
	

}
