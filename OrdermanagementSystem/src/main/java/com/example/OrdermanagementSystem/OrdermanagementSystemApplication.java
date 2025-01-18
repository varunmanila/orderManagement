package com.example.OrdermanagementSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages ="com.example.OrdermanagementSystem.Model")
public class OrdermanagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrdermanagementSystemApplication.class, args);
	}

}
