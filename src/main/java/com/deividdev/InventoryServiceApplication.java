package com.deividdev;

import com.deividdev.entity.Product;
import com.deividdev.repository.ProductRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class InventoryServiceApplication {

	@Autowired
	private ProductRepository repository;

	@PostConstruct
	public void initDB(){
		List<Product> products = Stream.of(
				new Product("Laptop", "Electronics", 10000.99F, 150),
				new Product("Smatphone", "Electronics", 39999.99F, 100),
				new Product("Office Chair", "Furniture", 14000.99F, 400),
				new Product("Notebook", "Stationery", 15400.99F, 340),
				new Product("Whater Bottle", "Accessories", 1400.00F, 120)

		).collect(Collectors.toList());
		repository.saveAll(products);

	}

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

}
