package com.tgdd.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.tgdd.entity.Manufacturer;

public interface ManufacturerService {

	Manufacturer getById(Long id);

	void deleteAll();

	void delete(Manufacturer entity);

	void deleteById(Long id);

	<S extends Manufacturer> List<S> saveAll(Iterable<S> entities);

	Optional<Manufacturer> findById(Long id);

	List<Manufacturer> findAll(Sort sort);

	List<Manufacturer> findAll();

	<S extends Manufacturer> S save(S entity);

}
