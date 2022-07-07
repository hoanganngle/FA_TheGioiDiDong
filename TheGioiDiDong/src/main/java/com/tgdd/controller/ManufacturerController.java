package com.tgdd.controller;



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
import com.tgdd.dto.ManufacturerDto;
import com.tgdd.entity.ResponseObject;
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
	public ResponseEntity<ResponseObject> updateManufacturer(@PathVariable long id,@Valid @RequestBody ManufacturerDto manufacturerDto) {
		return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok", "update Manufacturer successfully",
				manufacturerService.updateManufacturer(id, manufacturerDto)));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseObject> deleteManufacturer(@PathVariable("id") long id) {
		return ResponseEntity.status(HttpStatus.OK)
				.body(new ResponseObject("ok", "Delete Manufacturer successsful", manufacturerService.deleteManufacturer(id)));
	}
	@GetMapping
	public ResponseEntity<ResponseObject> getAllCategories() {
		return ResponseEntity.status(HttpStatus.OK)
				.body(new ResponseObject("ok", "List Manufacturer successfully", manufacturerService.getAllManufacturer()));
	}

}
