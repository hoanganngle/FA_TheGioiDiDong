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

import com.tgdd.dto.CategoryDto;
import com.tgdd.entity.ResponseObject;
import com.tgdd.exceptions.handlers.ResourceFoundExceptions;
import com.tgdd.service.CategoryService;

@RestController
@RequestMapping("categories")
public class CategoryController {
	@Autowired
	private CategoryService categoryService;

	@PostMapping
	public CategoryDto addCategory(@Valid @RequestBody CategoryDto categoryDto) throws ResourceFoundExceptions{
		return categoryService.addCategory(categoryDto);
	}

	@PutMapping("/{id}")
	public CategoryDto updateCategory(@PathVariable long id,@Valid @RequestBody CategoryDto categoryDto) throws ResourceFoundExceptions {
		return categoryService.updateCategory(id, categoryDto);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteCategory(@PathVariable("id") long id) throws ResourceFoundExceptions{
		categoryService.deleteCategory(id);
		return ResponseEntity.status(HttpStatus.OK)
				.body(String.format("delete category successfully"));
	}
	@GetMapping
	public List<CategoryDto> getAllCategories() {
		return categoryService.getAllCategory();
	}	
}
