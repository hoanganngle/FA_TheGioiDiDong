package com.tgdd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tgdd.entity.Product;
import com.tgdd.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository repo;

	public Product save(Product product) {
		return repo.save(product);

	}

	public List<Product> getAllProducts() {

		return repo.findAll();
	}

}
