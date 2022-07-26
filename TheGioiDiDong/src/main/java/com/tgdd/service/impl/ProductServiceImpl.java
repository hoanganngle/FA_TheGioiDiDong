package com.tgdd.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.tgdd.service.ProductService;
import com.tgdd.dto.ProductDto;
import com.tgdd.entity.Category;
import com.tgdd.entity.Product;
import com.tgdd.exceptions.handlers.ResourceFoundExceptions;
import com.tgdd.repository.CategoryRepository;
import com.tgdd.repository.ProductRepository;
import com.tgdd.response.MessageResponse;
@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	ProductRepository productRepository;
	@Autowired
	 CategoryRepository categoryRepository;
	@Autowired
	 ModelMapper modelMapper;

	
	
	@Override
	public ProductDto addProduct(ProductDto productDto) {
		Optional<Category> optionalCategory = categoryRepository.findById(productDto.getCategory().getCategoryId());
		if(!optionalCategory.isPresent()) {
			return ResponseEntity.badRequest().body(new MessageResponse("Category not found"));
		}
		
		productRepository.save(modelMapper.map(productDto,Product.class));
		return ResponseEntity.ok(new MessageResponse("Add new Product successfully"));
	}

	@Override
	public  ResponseEntity<?> updateProduct(Integer id, ProductDto productDto) {
				Optional<Product> optionalProduct = productRepository.findById(id);
				if(!optionalProduct.isPresent()) {
					throw new ResourceFoundExceptions("Product not found");
				}
				Optional<Category> optionalCategory = categoryRepository.findById(productDto.getCategory().getCategoryId());
				if(!optionalCategory.isPresent()) {
					return ResponseEntity.badRequest().body(new MessageResponse("Category not found"));
				}
				
				
				Product product = optionalProduct.get();

				modelMapper.map(productDto, product);
				product = productRepository.save(product);
				return ResponseEntity.ok(new MessageResponse("Update Product successfully"));
	}

	@Override
	public ResponseEntity<?> deleteProduct(Integer id) {
		Optional<Product> optional = productRepository.findById(id);
		if(optional.isPresent()) {
			Product product = optional.get();
			productRepository.delete(product);
				return ResponseEntity.ok(new MessageResponse("The book deleted successfully")) ;
			}	
		throw new ResourceFoundExceptions("Product is not found");
	}

	@Override
	public List<ProductDto> getAllProduct() {
		List<Product> list = productRepository.findAll();
		List<ProductDto> dto = new ArrayList<ProductDto>();
		list.forEach(b -> dto.add(modelMapper.map(b, ProductDto.class)));
		return dto ;
	}

	@Override
	public ResponseEntity<List<ProductDto>> getAllProductbyCategory(Integer categoryId) {
		List<Product> list = productRepository.getProductbyIdcategory(categoryId);
		List<ProductDto> dto = new ArrayList<ProductDto>();
		list.forEach(b -> dto.add(modelMapper.map(b, ProductDto.class)));
		return ResponseEntity.ok(dto) ;
		
	}

	@Override
	public ProductDto findByIdProduct(Integer id) {
				Optional<Product> optional = productRepository.findById(id);
				if(optional.isPresent()) {
					Product product = optional.get();
					return modelMapper.map(product, ProductDto.class);
				}
				throw new ResourceFoundExceptions("Product not found");
	}
}
