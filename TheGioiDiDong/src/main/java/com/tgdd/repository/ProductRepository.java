package com.tgdd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tgdd.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
	@Query("SELECT p FROM Product p where Category_id = :categoryId")
	 List<Product> getProductbyIdcategory(@Param("categoryId")Integer id);
	  List<Product> findByProductName(String productName);
	  Product findByProductId(Integer id);
}
