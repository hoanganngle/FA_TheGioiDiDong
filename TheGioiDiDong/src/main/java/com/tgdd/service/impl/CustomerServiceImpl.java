package com.tgdd.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.aspectj.lang.annotation.DeclareWarning;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tgdd.dto.CustomerDto;
import com.tgdd.dto.OrderDto;
import com.tgdd.entity.Customer;
import com.tgdd.exceptions.handlers.ResourceFoundExceptions;
import com.tgdd.repository.CustomerRepository;
import com.tgdd.service.CustomerService;
@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired 
	CustomerRepository customerRepository;
	
	@Autowired
	ModelMapper modelMapper;

	@Override
	public ResponseEntity<?> getOrdersbyPhoneNumber(Long phoneNumber) {
		Optional<Customer> optional = customerRepository.findById(phoneNumber);
		if(!optional.isPresent()) {
			throw new ResourceFoundExceptions("Account not found");	
		}
		Customer customer = optional.get();
		if(customer.getOrders().size()==0) {
			return ResponseEntity.ok("Account don't have orders");
		}
		List<OrderDto> list = new ArrayList<OrderDto>();
		customer.getOrders().forEach(order -> list.add(modelMapper.map(order, OrderDto.class)));
		return ResponseEntity.ok(list);
	}

	@Override
	public Customer getCustomerByPhoneNumber(Long phoneNumber) {
		// TODO Auto-generated method stub
		return customerRepository.getById(phoneNumber);
	}

	@Override
	public CustomerDto addCustomer(@Valid CustomerDto customerDto) {
		Customer customer = customerRepository.save(modelMapper.map(customerDto, Customer.class));
		
		return modelMapper.map(customer, CustomerDto.class);
	}

}
