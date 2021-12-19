package com.eshopping.ewallet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableEurekaClient
@EnableMongoRepositories
public class EwalletServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EwalletServiceApplication.class, args);
		System.out.println("Ewallet Service started");
	}

}
