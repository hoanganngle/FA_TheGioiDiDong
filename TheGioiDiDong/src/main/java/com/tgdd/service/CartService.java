package com.tgdd.service;
import java.util.Collection;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tgdd.dto.CartDto;
@Service
public interface CartService {
	public Collection<CartDto> getCartByPhoneNumber(Long phoneNumber);
	
	public ResponseEntity<?> addCart(CartDto cartDto);
	
	public ResponseEntity<?> updateCart(Long id, CartDto cartDto);
	
	public ResponseEntity<?> deleteCart(Long phoneNumber);

	

}
