//package com.tgdd.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.tgdd.dto.CustomerDto;
//import com.tgdd.dto.CartDto;
//import com.tgdd.entity.Customer;
//import com.tgdd.service.CartService;
//import com.tgdd.service.CustomerService;
//
//
//@RestController
//@RequestMapping("cart")
//public class CartController {
//
//	@Autowired
//	private CustomerService customerService;
//	
//	@Autowired
//	private CartService cartService;
//	
//	@GetMapping("/{myCart}")
//	public ResponseEntity<?> getCartByPhoneNumber(@PathVariable("phoneNumber") Long phoneNumber){
//		return cartService.getCartByPhoneNumber(phoneNumber);
//	}
//	
//	@PostMapping("/")
//	public ResponseEntity<?> addCart(@RequestBody CartDto cartDto){
//		return cartService.addCart(cartDto);
//	}
//	
//	@PutMapping("/{myCart}")
//	public ResponseEntity<?> updateCart(@PathVariable("phoneNumber")Long phoneNumber,@RequestBody CartDto cartDto){
//		return cartService.updateCart(phoneNumber, cartDto);
//	}
//	
//	@DeleteMapping("/{myCart}")
//	public ResponseEntity<?> deleteCart(@PathVariable Long phoneNumber){
//		return cartService.deleteCart(phoneNumber);
//	}
//
//	@PostMapping("")
//	public CustomerDto addCustomer(@RequestBody CustomerDto customerDto){
//		return customerService.addCustomer(customerDto);
//	}
//	
//	@GetMapping("/{phoneNumber}")
//	public Customer getOneCustomer(@PathVariable("phoneNumber") Long phoneNumber) {
//		return customerService.getCustomerByPhoneNumber(phoneNumber);
//	}
//}
