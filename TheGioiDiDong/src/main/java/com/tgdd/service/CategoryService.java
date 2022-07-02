package com.tgdd.service;

import java.util.List;
import java.util.Optional;
import com.tgdd.entity.Category;

public interface CategoryService {

	//add category
	Category addCategory(Category category);
	
	// update category
	Category updateCategories(long id, Category category);

	// delete category
	void deleteCategory(long id);

	// list category
	List<Category> getAllCategories();

	// get 1 category
	Optional<Category> findCategoriesById(long id);

}
