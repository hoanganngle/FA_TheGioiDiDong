package com.tgdd.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.tgdd.dto.CartDto;
import com.tgdd.dto.CustomerDto;
import com.tgdd.entity.Cart;
import com.tgdd.repository.CartRepository;
import com.tgdd.repository.CustomerRepository;
import com.tgdd.repository.ProductRepository;
import com.tgdd.response.MessageResponse;
import com.tgdd.service.CartService;
import com.tgdd.service.ProductService;


import com.tgdd.entity.Customer;
import com.tgdd.entity.Product;
import com.tgdd.exceptions.handlers.ResourceFoundExceptions;
import com.tgdd.repository.ProductRepository;

@Component
public class CartServiceImpl implements CartService{
	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	CartRepository cartRepository;
	
	@Autowired
	ProductService productService;
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Override
	public Collection<CartDto> getCartByPhoneNumber(Long phoneNumber) {
		List<Cart> list = cartRepository.findByPhoneNumber(phoneNumber);
		List<CartDto> dto = new ArrayList<CartDto>();
		list.forEach(c -> dto.add(modelMapper.map(c, CartDto.class)));
		return dto;
	}
	
	@Override
	public ResponseEntity<?> addCart(CartDto cartDto) {
		// TODO Auto-generated method stub
		Optional<Product> optionalProduct = productRepository.findById(cartDto.getProducts().getIdProduct());
		if (!optionalProduct.isPresent()) {
			throw new ResourceFoundExceptions("Product not found");
		}
	
			cartRepository.save(modelMapper.map(cartDto, Cart.class));

		return ResponseEntity.ok(new MessageResponse("Cart is added successfully"));

	}
	
	@Override
	public ResponseEntity<?> updateCart(Long id,CartDto cartDto) {
		Optional<Product> optionalProduct = productRepository.findById(cartDto.getProducts().getIdProduct());
		if (!optionalProduct.isPresent()) {
			throw new ResourceFoundExceptions("Product not found");
		}
		
		Optional<Cart> optionalCart = cartRepository.findById(id);
		if (optionalCart.isPresent()) {
			Cart cart = optionalCart.get();
			if (cart.getQuantity() == 0) {
				cartRepository.delete(cart);
			}
			cart.setQuantity(cartDto.getQuantity());
			cartRepository.save(cart);
			return ResponseEntity.ok(new MessageResponse("Cart is updated successfully"));
		}
		throw new ResourceFoundExceptions("Cart not found");
	}
	
	@Override
	public ResponseEntity<?> deleteCart(Long phoneNumber) {
		Optional<Customer> optionalCustomer = customerRepository.findById(phoneNumber);
		if(!optionalCustomer.isPresent()) {
			throw new ResourceFoundExceptions("Account not found");
		}
		List<Cart> list = cartRepository.findByPhoneNumber(phoneNumber);
		cartRepository.deleteAll(list);
		return ResponseEntity.ok(new MessageResponse("Deleted successfully"));
	}

	
	
	
	

	
	
	

}
