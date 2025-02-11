package com.training.microservices.storeservices;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
//import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Bean;

import com.training.microservices.storeservices.entity.Product;
import com.training.microservices.storeservices.repositories.ProductRepostories;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
//@EnableEurekaServer
@Slf4j
public class StoreservicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(StoreservicesApplication.class, args);
	}
	
	//@Bean
	public CommandLineRunner demo(ProductRepostories repository) {
		return (args) -> {
			// save a few customers
			repository.save(Product.builder().name("iPhone").brand("Apple").value("$1000").build());
			repository.save(Product.builder().name("S21").brand("Samsung").value("$1200").build());
			repository.save(Product.builder().name("ONED").brand("LG").value("$900").build());
			repository.save(Product.builder().name("Inspiron").brand("Dell").value("$1100").build());
			repository.save(Product.builder().name("DS3300").brand("Nikon").value("$600").build());

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
