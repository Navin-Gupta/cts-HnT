package com.cts.training.bootappjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.cts.training.bootappjpa.entity.Product;

@Component
public interface ProductRepository extends JpaRepository<Product, Integer>{

}
