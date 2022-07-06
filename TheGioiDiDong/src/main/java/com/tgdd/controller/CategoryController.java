package com.tgdd.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tgdd.entity.Category;
import com.tgdd.service.CategoryService;

@RestController
@RequestMapping("categories")
public class CategoryController {
	@Autowired
	private CategoryService categoryService;

//add
	@PostMapping
	public ResponseEntity<Category> addCategory(@Validated @RequestBody Category category) {

		return new ResponseEntity<>(categoryService.addCategory(category), HttpStatus.OK);

	}

//Update
	@PutMapping("/{categoryId}")
	public ResponseEntity<Category> updateCategory(@PathVariable Long categoryId, @RequestBody Category category) {
		Optional<Category> categoryOptional = categoryService.findCategoriesById(categoryId);
		return categoryOptional.map(category1 -> {
			category.setCategoryId(category1.getCategoryId());
			return new ResponseEntity<>(categoryService.addCategory(category), HttpStatus.OK);
		}).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

//delete
	@DeleteMapping("/{categoryId}")
	private ResponseEntity<Category> deleteCategory(@PathVariable Long categoryId) {
		Optional<Category> categoryOptional = categoryService.findCategoriesById(categoryId);
		return categoryOptional.map(category -> {
			categoryService.deleteCategory(categoryId);
			return new ResponseEntity<>(category, HttpStatus.OK);
		}).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));

	}

//get all
	@GetMapping
	public ResponseEntity<Iterable<Category>> getAllCategory() {
		return new ResponseEntity<>(categoryService.getAllCategories(), HttpStatus.OK);
	}

//	find by id
	@GetMapping("/{categoryId}")
	public ResponseEntity<Category> getCategory(@PathVariable Long categoryId) {
		Optional<Category> categoryOptional = categoryService.findCategoriesById(categoryId);
		return categoryOptional.map(category -> new ResponseEntity<>(category, HttpStatus.OK))
				.orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
}
