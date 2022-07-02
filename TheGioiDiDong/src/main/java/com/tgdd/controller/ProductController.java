package com.tgdd.controller;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tgdd.repository.ProductRepository;
import com.tgdd.entity.Product;
import com.tgdd.service.ProductService;

public class ProductController {
	
	private ProductRepository repopr;
	
	private ProductService productService;
	
	@GetMapping("/list_product")
	public String viewProductList(Model model) {
		List<Product> listProduct = repopr.findAll();
		model.addAttribute("listProduct", listProduct);
		return "product";
	}

	@GetMapping("/new")
	public String showNewProductPage(Model model) {
		Product pr = new Product();
		model.addAttribute("newpr", pr);
		return "createproduct";
	}

	@RequestMapping("/edit/{id}")
	public ModelAndView showEditProductPage(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("edit_product");
		Product product = productService.get(id);
		mav.addObject("newpr", product);
		return mav;
	}

	@RequestMapping("/delete/{id}")
	public String deleteProduct(@PathVariable(name = "id") int id) {
		productService.DeteleProduct(id);
		return "redirect:/list_product";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveProduct(@ModelAttribute("newpr") Product product) {
		repopr.save(product);
		return "redirect:/list_product";
	}

	@GetMapping("/list_product/{id}")
	public String getProductId(Model model, @PathVariable("id") Integer id) {
		Product product = productService.get(id);
		model.addAttribute("product", product);
		return "viewproduct";
	}
}
