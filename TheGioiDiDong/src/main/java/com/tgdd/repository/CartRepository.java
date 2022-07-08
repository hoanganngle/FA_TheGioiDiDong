package com.tgdd.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tgdd.entity.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {	
	@Query("SELECT c FROM Cart c WHERE c.customer.phoneNumber = :phoneNumber")
	public List<Cart> findByPhoneNumber(Long phoneNumber);

}
