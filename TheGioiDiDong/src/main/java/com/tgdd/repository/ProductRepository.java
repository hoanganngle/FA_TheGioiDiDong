package com.tgdd.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tgdd.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	@Query("SELECT p FROM Product p where Category_id = :categoryId")
	 List<Product> getProductbyIdcategory(@Param("categoryId")Long id);
	
	@Query("SELECT p FROM Product p where Product_Name LIKE CONCAT('%',:productname, '%')")
	List<Product> getProductbyProductName(@Param("productname") String name);
	
	  List<Product> findByProductName(String productName);
	  Product findByProductId(Long id);
}
