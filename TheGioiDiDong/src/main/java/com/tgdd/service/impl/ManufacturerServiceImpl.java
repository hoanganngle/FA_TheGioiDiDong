package com.tgdd.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tgdd.dto.ManufacturerDto;
import com.tgdd.entity.Manufacturer;
import com.tgdd.repository.ManufacturerRepository;
import com.tgdd.service.ManufacturerService;

import com.tgdd.response.MessageResponse;

import com.tgdd.exceptions.handlers.ResourceFoundExceptions;
@Service
public class ManufacturerServiceImpl implements ManufacturerService {
	
	@Autowired
	ManufacturerRepository manufacturerRepository;
	
	@Autowired
	ModelMapper modelMapper;

	@Override
	public ManufacturerDto addManufacturer(ManufacturerDto manufacturerDto) {
		Manufacturer manufacturer = manufacturerRepository.save(modelMapper.map(manufacturerDto, Manufacturer.class));
		
		return modelMapper.map(manufacturer, ManufacturerDto.class);
	}

	@Override
	public ManufacturerDto updateManufacturer(long id, ManufacturerDto manufacturerDto) {
		Optional<Manufacturer> manufacturerOptional = manufacturerRepository.findById(id);
		if(manufacturerOptional.isPresent()) {
			Manufacturer manufacturer = manufacturerOptional.get();
			modelMapper.map(manufacturerDto, manufacturer);
			manufacturer = manufacturerRepository.save(manufacturer);
			return modelMapper.map(manufacturer, ManufacturerDto.class);
		}
		throw new ResourceFoundExceptions("Category not found");
	}

	@Override
	public ResponseEntity<?> deleteManufacturer(long id) {
		Optional<Manufacturer> optional = manufacturerRepository.findById(id);
		if(optional.isPresent()) {
			Manufacturer manufacturer = optional.get();
				manufacturerRepository.delete(manufacturer);
				return ResponseEntity.ok(new MessageResponse("The category deleted successfully"));
			}
		throw new ResourceFoundExceptions("Category is not found");
	}

	@Override
	public List<ManufacturerDto> getAllManufacturer() {
		List<Manufacturer> list = manufacturerRepository.findAll();
		List<ManufacturerDto> listDto = new ArrayList<ManufacturerDto>();
		list.forEach(c -> listDto.add(modelMapper.map(c, ManufacturerDto.class)));
		return listDto;
	}

	@Override
	public Manufacturer findbyIdManufacturer(long id) {
		return null;
	}


	

}
