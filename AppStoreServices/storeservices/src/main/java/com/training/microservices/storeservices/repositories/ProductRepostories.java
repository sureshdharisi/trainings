package com.training.microservices.storeservices.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.training.microservices.storeservices.entity.Product;

@Component
public interface ProductRepostories extends JpaRepository<Product, Integer>{

	List<Product> findByName(String name);
}
