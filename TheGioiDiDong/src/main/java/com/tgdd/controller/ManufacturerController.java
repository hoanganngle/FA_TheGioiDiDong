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
import com.tgdd.dto.ManufacturerDto;
import com.tgdd.entity.Category;
import com.tgdd.entity.Manufacturer;
import com.tgdd.service.CategoryService;
import com.tgdd.service.ManufacturerService;
@Controller
@RequestMapping("manufacturers")
public class ManufacturerController {
	@Autowired
	ManufacturerService manufacturerService;

	
	@GetMapping("add")
	public String add(Model model) {
		model.addAttribute("manufacturer", new ManufacturerDto());
		
		return "manufacturers/addOrEdit";
	}
	@GetMapping("edit/{manufacturerId}")
	public ModelAndView edit(ModelMap model, @PathVariable("manufacturerId") long manufacturerId) {
		Optional<Manufacturer> opt = manufacturerService.findById(manufacturerId);
		ManufacturerDto dto = new ManufacturerDto();
		if(opt.isPresent()) {
			Manufacturer entity = opt.get();
			BeanUtils.copyProperties(entity, dto);
			dto.setIsEdit(true);
			
			model.addAttribute("manufacturer", dto);
			return new ModelAndView("manufacturers/addOrEdit",model);
		}
		model.addAttribute("message", "Manufacturer is not exited");
		
		return new ModelAndView("forward:/manufacturers",model);
	}
	@GetMapping("delete/{manufacturerId}")
	public String delete() {
		return "redirect:/manufacturers ";
	}
	@PostMapping("saveOrUpdate")
	public ModelAndView saveOrUpdate(ModelMap model,CategoryDto dto) {
		Manufacturer entity = new Manufacturer();
		BeanUtils.copyProperties(dto, entity);
		manufacturerService.save(entity);
		model.addAttribute("message", "Manufacturer is Saved!");
		return new ModelAndView("forward:/manufacturers", model);
	}
	@RequestMapping("")
	public String list(ModelMap model) {
		List<Manufacturer> list = manufacturerService.findAll();
		model.addAttribute("manufacturers", list);
		return "manufacturers/list";
	}
	@GetMapping("search")
	public String search() {
		return "manufacturers/search";
	}
}
