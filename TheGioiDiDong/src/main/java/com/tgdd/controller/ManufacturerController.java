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
import com.tgdd.dto.ManufacturerDto;
import com.tgdd.entity.ResponseObject;
import com.tgdd.exceptions.handlers.ResourceFoundExceptions;
import com.tgdd.service.ManufacturerService;

@RestController
@RequestMapping("manufacturers")
public class ManufacturerController {
	@Autowired
	ManufacturerService manufacturerService;
	
	@PostMapping
	public ManufacturerDto addManufacturer(@Valid @RequestBody ManufacturerDto manufacturerDto) {
		return manufacturerService.addManufacturer(manufacturerDto);
	}
	
	@PutMapping("/{id}")
	public ManufacturerDto updateManufacturer(@PathVariable long id,@Valid @RequestBody ManufacturerDto manufacturerDto) throws ResourceFoundExceptions {
		return manufacturerService.updateManufacturer(id, manufacturerDto);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteManufacturer(@PathVariable("id") long id) throws ResourceFoundExceptions{
		manufacturerService.deleteManufacturer(id);
		return ResponseEntity.status(HttpStatus.OK)
				.body(String.format("delete Manufacturer successfully"));
	}
	@GetMapping
	public List<ManufacturerDto> getAllManufacturer() {
		return manufacturerService.getAllManufacturer();
	}	

}
