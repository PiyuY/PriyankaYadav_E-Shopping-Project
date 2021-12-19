package com.priyanka.productservice.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@RequestMapping("/test")
	public String proHome() {
		return "This is Product Service.";
	}
}
