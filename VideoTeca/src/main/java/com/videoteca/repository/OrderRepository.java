package com.videoteca.repository;

import org.springframework.data.repository.CrudRepository;

import com.videoteca.entity.Order;

public interface OrderRepository extends CrudRepository<Order, Integer>{

}