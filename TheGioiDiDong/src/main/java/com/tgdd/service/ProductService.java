package com.tgdd.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tgdd.dto.ProductDto;
import com.tgdd.exceptions.handlers.ResourceNotFoundException;

@Service
public interface ProductService {

	ResponseEntity<?> addProduct(ProductDto productDtO);

	ResponseEntity<?> updateProduct(long id, ProductDto productDTO) throws ResourceNotFoundException;

	ResponseEntity<?> deleteProduct(long id) throws ResourceNotFoundException;

	ResponseEntity<?> getAllProduct();

	ResponseEntity<?> getAllProductbyCategory(long id);
	
	ResponseEntity<?> getProductbyProductName(String name);


	ProductDto findByIdProduct(long id) throws ResourceNotFoundException;
}
