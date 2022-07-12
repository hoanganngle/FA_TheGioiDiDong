package com.tgdd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tgdd.service.CustomerService;

@RestController
@RequestMapping("customer")
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/{phoneNumber}")
	public ResponseEntity<?> getOrders(@PathVariable("phoneNumber") long phoneNumber){
		return customerService.getOrdersbyPhoneNumber(phoneNumber);
		
	}

}
