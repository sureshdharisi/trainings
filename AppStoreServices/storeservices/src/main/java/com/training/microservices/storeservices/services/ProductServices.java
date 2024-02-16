package com.training.microservices.storeservices.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.microservices.storeservices.entity.Product;
import com.training.microservices.storeservices.repositories.ProductRepostories;

@Service
public class ProductServices {
	
	@Autowired
	public ProductRepostories productRepostories;

	public List<Product> getProducts(String name){
		return productRepostories.findByName(name);
	}
}
