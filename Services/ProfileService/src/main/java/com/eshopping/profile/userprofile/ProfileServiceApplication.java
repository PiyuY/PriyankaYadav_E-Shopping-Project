package com.eshopping.profile.userprofile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.client.RestTemplate;

import springfox.documentation.swagger2.annotations.EnableSwagger2;




@SpringBootApplication
@EnableSwagger2
@EnableEurekaClient
@EnableMongoRepositories
@EnableHystrix
public class ProfileServiceApplication {

	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplateObj() {
		return new RestTemplate();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(ProfileServiceApplication.class, args);
		System.out.println("Profile Service Started");
	}

}
