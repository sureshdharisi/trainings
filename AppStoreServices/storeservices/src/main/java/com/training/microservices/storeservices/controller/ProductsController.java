package com.training.microservices.storeservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.microservices.storeservices.entity.Product;
import com.training.microservices.storeservices.services.ProductServices;

@RestController
@RequestMapping("/v1/products")
public class ProductsController {
	
	@Autowired
	private ProductServices productServices;

	
	@GetMapping("/{id}")
	public Product getProduct(@PathVariable("id") Integer id){
		return productServices.getProduct(id);
	}
	
	@GetMapping
	public List<Product> getProducts(){
		return productServices.getProducts();
	}
}
