package com.tgdd.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tgdd.dto.CategoryDto;
import com.tgdd.entity.Category;

@Service
public interface CategoryService {

	public CategoryDto addCategory(CategoryDto categoryDto);

	public CategoryDto updateCategory(long id , CategoryDto categoryDto);

	public ResponseEntity<?>  deleteCategory(long id);
	
	public List<CategoryDto> getAllCategory();
	
	public Category findbyIdCategory(long id);
	
	
}
