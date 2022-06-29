package com.tgdd.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
		model.addAttribute("category", new Category());
		
		return "categories/addOrEdit";
	}
	@GetMapping("edit/{categoruId}")
	public String edit() {
		return "categories/addOrEdit";
	}
	@GetMapping("delete/{categoryId}")
	public String delete() {
		return "redirect:/categories ";
	}
	@PostMapping("saveOrUpdate")
	public ModelAndView saveOrUpdate(ModelMap model,Category cat) {
		Category entity = new Category();
		BeanUtils.copyProperties(cat, entity);
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
