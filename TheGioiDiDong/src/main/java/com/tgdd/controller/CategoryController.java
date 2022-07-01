package com.tgdd.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tgdd.dto.CategoryDto;
import com.tgdd.entity.Category;
import com.tgdd.service.CategoryService;

import ch.qos.logback.core.joran.util.beans.BeanUtil;

@Controller
@RequestMapping("categories")
public class CategoryController {
	@Autowired
	CategoryService categoryService;

	
	@GetMapping("add")
	public String add(Model model) {
		model.addAttribute("category", new CategoryDto());
		
		return "categories/addOrEdit";
	}
	@GetMapping("edit/{categoryId}")
	public ModelAndView edit(ModelMap model, @PathVariable("categoryId") long categoryId) {
		Optional<Category> opt = categoryService.findById(categoryId);
		CategoryDto dto = new CategoryDto();
		if(opt.isPresent()) {
			Category entity = opt.get();
			BeanUtils.copyProperties(entity, dto);
			dto.setIsEdit(true);
			
			model.addAttribute("category", dto);
			return new ModelAndView("categories/addOrEdit",model);
		}
		model.addAttribute("message", "Category is not exited");
		
		return new ModelAndView("forward:/categories",model);
	}
	@GetMapping("delete/{categoryId}")
	public String delete() {
		return "redirect:/categories ";
	}
	@PostMapping("saveOrUpdate")
	public ModelAndView saveOrUpdate(ModelMap model,CategoryDto dto) {
		Category entity = new Category();
		BeanUtils.copyProperties(dto, entity);
		categoryService.save(entity);
		model.addAttribute("message", "Category is Saved!");
		return new ModelAndView("forward:/categories", model);
	}
	@RequestMapping("")
	public String list(ModelMap model) {
		List<Category> list = categoryService.findAll();
		model.addAttribute("categories", list);
		return "categories/list";
	}
	@GetMapping("search")
	public String search() {
		return "categories/search";
	}
}
