package com.tgdd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tgdd.entity.Order;
@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{

}
