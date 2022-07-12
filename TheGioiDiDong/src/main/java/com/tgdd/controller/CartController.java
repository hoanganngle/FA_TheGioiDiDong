package com.tgdd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tgdd.dto.CustomerDto;
import com.tgdd.entity.Customer;
import com.tgdd.service.CustomerService;

@RestController
@RequestMapping("cart")
public class CartController {

	@Autowired
	private CustomerService customerService;
	
	@PostMapping("")
	public CustomerDto addCustomer(@RequestBody CustomerDto customerDto){
		return customerService.addCustomer(customerDto);
	}
	@GetMapping("/{phoneNumber}")
	public Customer getOneCustomer(@PathVariable("phoneNumber") Long phoneNumber) {
		return customerService.getCustomerByPhoneNumber(phoneNumber);
	}
}
