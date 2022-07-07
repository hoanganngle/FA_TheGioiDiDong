package com.tgdd.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tgdd.dto.ManufacturerDto;
import com.tgdd.entity.Manufacturer;

@Service
public interface ManufacturerService {

	public ManufacturerDto addManufacturer(ManufacturerDto manufacturerDto);

	public ManufacturerDto updateManufacturer(long id , ManufacturerDto manufacturerDto);

	public ResponseEntity<?>  deleteManufacturer(long id);
	
	public List<ManufacturerDto> getAllManufacturer();
	
	public Manufacturer findbyIdManufacturer(long id);
	

}
