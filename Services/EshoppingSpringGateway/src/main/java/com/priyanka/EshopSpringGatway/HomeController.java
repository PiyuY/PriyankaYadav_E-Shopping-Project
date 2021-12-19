package com.priyanka.EshopSpringGatway;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HomeController {

	@RequestMapping("/view")
	public String home() {
		return "hey! Hello All! I'm API Gateway Zuuuuuuuuuuul...";
	}
	
}