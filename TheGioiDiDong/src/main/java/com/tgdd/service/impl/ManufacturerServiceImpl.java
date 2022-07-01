package com.tgdd.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.tgdd.entity.Manufacturer;
import com.tgdd.repository.ManufacturerRepository;
import com.tgdd.service.ManufacturerService;
@Service
public class ManufacturerServiceImpl implements ManufacturerService {
	ManufacturerRepository manufacturerRepository;

	public ManufacturerServiceImpl(ManufacturerRepository manufacturerRepository) {
		this.manufacturerRepository = manufacturerRepository;
	}

	@Override
	public <S extends Manufacturer> S save(S entity) {
		return manufacturerRepository.save(entity);
	}

	@Override
	public List<Manufacturer> findAll() {
		return manufacturerRepository.findAll();
	}

	@Override
	public List<Manufacturer> findAll(Sort sort) {
		return manufacturerRepository.findAll(sort);
	}

	@Override
	public Optional<Manufacturer> findById(Long id) {
		return manufacturerRepository.findById(id);
	}

	@Override
	public <S extends Manufacturer> List<S> saveAll(Iterable<S> entities) {
		return manufacturerRepository.saveAll(entities);
	}

	@Override
	public void deleteById(Long id) {
		manufacturerRepository.deleteById(id);
	}

	@Override
	public void delete(Manufacturer entity) {
		manufacturerRepository.delete(entity);
	}

	@Override
	public void deleteAll() {
		manufacturerRepository.deleteAll();
	}

	@Override
	public Manufacturer getById(Long id) {
		return manufacturerRepository.getById(id);
	}
	
	

}
