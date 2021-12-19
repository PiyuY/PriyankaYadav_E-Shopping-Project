package com.priyanka.EshopSpringGatway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient
public class EshopSpringGatwayApplication {

	public static void main(String[] args) {
		SpringApplication.run(EshopSpringGatwayApplication.class, args);
		System.out.println("Spring cloud gateway started...");
	}

}
