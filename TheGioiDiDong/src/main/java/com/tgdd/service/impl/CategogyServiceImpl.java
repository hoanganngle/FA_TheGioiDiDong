package com.tgdd.service.impl;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tgdd.entity.Category;
import com.tgdd.repository.CategoryRepository;
import com.tgdd.service.CategoryService;
@Service
public class CategogyServiceImpl implements CategoryService{
	@Autowired
	private CategoryRepository categoryRepository;


	@Override
	public Category addCategory(@Valid Category category) {
		return categoryRepository.save(category);
	}


	@Override
	public Category updateCategories(long id, Category category) {
		if (category != null) {
			@SuppressWarnings("deprecation")
			Category categoryById = categoryRepository.getById(id);
			if (categoryById != null) {
				categoryById.setCategoryName(category.getCategoryName());

				return categoryRepository.save(categoryById);
			}
		}
		return null;
	}

	@Override
	public void deleteCategory(long id) {
		categoryRepository.deleteById(id);
		
	}

	@Override
	public List<Category> getAllCategories() {
		// TODO Auto-generated method stub
		return categoryRepository.findAll();
	}

	@Override
	public Optional<Category> findCategoriesById(long id) {
		// TODO Auto-generated method stub
		return categoryRepository.findById(id);
	}



	

}
