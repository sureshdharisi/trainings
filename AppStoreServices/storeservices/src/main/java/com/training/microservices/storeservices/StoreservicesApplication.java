package com.training.microservices.storeservices;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.training.microservices.storeservices.entity.Product;
import com.training.microservices.storeservices.repositories.ProductRepostories;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class StoreservicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(StoreservicesApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(ProductRepostories repository) {
		return (args) -> {
			// save a few customers
			repository.save(Product.builder().name("iPhone").build());
			repository.save(Product.builder().name("Samsung").build());
			repository.save(Product.builder().name("LG").build());
			repository.save(Product.builder().name("Laptop").build());
			repository.save(Product.builder().name("Monitor").build());

			// fetch all customers
			log.info("Products found with findAll():");
			log.info("-------------------------------");
			repository.findAll().forEach(customer -> {
				log.info(customer.toString());
			});
			log.info("");

			
			// fetch products by name
			log.info("Customer found with findByLastName('Bauer'):");
			log.info("--------------------------------------------");
			repository.findByName("Samsung").forEach(product -> {
				log.info(product.toString());
			});
			log.info("");
		};
	}


}
