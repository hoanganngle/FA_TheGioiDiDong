package com.tgdd.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tgdd.dto.ProductDto;
import com.tgdd.entity.Product;


@Service
public interface ProductService {


ResponseEntity<?> addProduct(ProductDto productDto);
	
	ResponseEntity<?> updateProduct(Integer id , ProductDto productDto);

	ResponseEntity<?> deleteProduct(Integer id);
	
	 ResponseEntity<?> getAllProduct();
	
	 List<ProductDto> getAllProductbyCategory(long id);

	 ProductDto findByIdProduct(Integer id);
}


