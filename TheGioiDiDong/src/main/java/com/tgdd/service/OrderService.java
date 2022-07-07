package com.tgdd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tgdd.entity.Order;
import com.tgdd.repository.OrderRepository;

@Service
public class OrderService {

     @Autowired
    OrderRepository repo;

    public int getIdOrder() {
        return repo.getIdOrder();
    }
    
    public void save(Order order){
        repo.save(order);
    }

}

