package com.tgdd.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tgdd.dto.CategoryDto;
import com.tgdd.dto.ProductDto;
import com.tgdd.entity.Product;

@Service
public interface ProductService {

	public ProductDto addProduct(ProductDto productDto);

	public ProductDto updateProduct(Integer id, ProductDto productDto);

	public ResponseEntity<?> deleteProduct(Integer id);

	public List<ProductDto> getAllProduct();

	public ProductDto findByIdProduct(Integer id);

	public ProductDto getAllProductbyCategory(Integer categoryId);
}
