package com.tgdd.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tgdd.repository.ProductRepository;
import com.tgdd.dto.CategoryDto;
import com.tgdd.dto.ProductDto;
import com.tgdd.entity.Product;
import com.tgdd.entity.ResponseObject;
import com.tgdd.service.ProductService;
@RestController
@RequestMapping("products")
public class ProductController {
//	Preauthorize chưa có login nên để vào cmt
	@Autowired
	private ProductService productServices;

	@PostMapping("/")
//	@PreAuthorize("hasAuthority('admin')")

	public ProductDto addProduct(@Valid @RequestBody ProductDto productDto) {
		return productServices.addProduct(productDto);
	}

	@PutMapping("/{id}")
//	@PreAuthorize("hasAuthority('admin')")

	public ProductDto updateProduct(@PathVariable("id") Integer id, @Valid @RequestBody ProductDto productDto) {

		return productServices.updateProduct(id, productDto);

	}

	@DeleteMapping("/{id}")
//	@PreAuthorize("hasAuthority('admin')"))
	public ResponseEntity<?> deleteProduct(@PathVariable("id") Integer id) {
		return productServices.deleteProduct(id);
	}

	@GetMapping
	public List<ProductDto> getAllProducts() {
		return productServices.getAllProduct();
	}

	@GetMapping("/{id}")
	public ResponseEntity<ResponseObject> getAllProductsByCategory(@PathVariable("id") Integer id) {
		return ResponseEntity.status(HttpStatus.OK).body(
				new ResponseObject("ok", "List product successfully", productServices.getAllProductbyCategory(id)));

	}
}
