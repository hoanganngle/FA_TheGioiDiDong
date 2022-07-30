package com.tgdd.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tgdd.service.ProductService;
import com.tgdd.dto.ProductDto;
import com.tgdd.entity.Category;
import com.tgdd.entity.Manufacturer;
import com.tgdd.entity.Product;
import com.tgdd.exceptions.handlers.ResourceNotFoundException;
import com.tgdd.repository.CategoryRepository;
import com.tgdd.repository.ManufacturerRepository;
import com.tgdd.repository.ProductRepository;
import com.tgdd.response.MessageResponse;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ManufacturerRepository manufacturerRepository;

	@Autowired
	private ModelMapper modelMapper;

	public ProductServiceImpl(ProductRepository productRepository2, CategoryRepository categoryRepository2) {
		this.productRepository = productRepository2;
		this.categoryRepository = categoryRepository2;
	}

	@Override
	public ResponseEntity<?> addProduct(ProductDto productDTO) {
		Optional<Category> categoryOptional = categoryRepository.findById(productDTO.getCategory().getCategoryId());
		Optional<Manufacturer> maufacturerOptional =  manufacturerRepository.findById(productDTO.getManufacturer().getManufacturerId());

		if (!categoryOptional.isPresent()) {
			return ResponseEntity.badRequest().body(new MessageResponse("Category not found"));
		}
		if (!maufacturerOptional.isPresent()) {
			return ResponseEntity.badRequest().body(new MessageResponse("<anufacturer not found"));
		}

		productRepository.save(modelMapper.map(productDTO, Product.class));
		return ResponseEntity.ok(new MessageResponse("Add new Product successfully"));
	}

	@Override
	public ResponseEntity<?> updateProduct(long id, ProductDto productDTO) throws ResourceNotFoundException {
		Optional<Product> optionalProduct = productRepository.findById(id);
		if (!optionalProduct.isPresent()) {
			throw new ResourceNotFoundException("Product not found");
		}
		Optional<Category> categoryOptional = categoryRepository.findById(productDTO.getCategory().getCategoryId());
		if (!categoryOptional.isPresent()) {
			return ResponseEntity.badRequest().body(new MessageResponse("Category not found"));
		}

		Product product = optionalProduct.get();

		modelMapper.map(productDTO, product);
		product = productRepository.save(product);
		return ResponseEntity.ok(new MessageResponse("Update Product successfully"));

	}

	@Override
	public ResponseEntity<?> deleteProduct(long id) throws ResourceNotFoundException {
		Optional<Product> optional = productRepository.findById(id);
		if (optional.isPresent()) {
			Product product = optional.get();
			productRepository.delete(product);
			return ResponseEntity.ok(new MessageResponse("The book deleted successfully"));
		}
		throw new ResourceNotFoundException("Product is not found");
	}

	@Override
	public ResponseEntity<?> getAllProduct() {
		List<Product> list = productRepository.findAll();
		List<ProductDto> dto = new ArrayList<ProductDto>();
		list.forEach(b -> dto.add(modelMapper.map(b, ProductDto.class)));
		return ResponseEntity.ok(dto);
	}

	@Override
	public ResponseEntity<?> getAllProductbyCategory(long id) {
		List<Product> list = productRepository.getProductbyIdcategory(id);
		List<ProductDto> dto = new ArrayList<ProductDto>();
		list.forEach(b -> dto.add(modelMapper.map(b, ProductDto.class)));
		return ResponseEntity.ok(dto);
	}
	
	@Override
	public ResponseEntity<?> getProductbyProductName(String name) {
		List<Product> list = productRepository.getProductbyProductName(name);
		List<ProductDto> dto = new ArrayList<ProductDto>();
		list.forEach(b -> dto.add(modelMapper.map(b, ProductDto.class)));
		return ResponseEntity.ok(dto);
	}

	@Override
	public ProductDto findByIdProduct(long id) throws ResourceNotFoundException {
		Optional<Product> optional = productRepository.findById(id);
		if (optional.isPresent()) {
			Product product = optional.get();
			return modelMapper.map(product, ProductDto.class);
		}
		throw new ResourceNotFoundException("Product not found");
	}

}
