package com.eshopping.profile.userprofile.dao;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.eshopping.profile.userprofile.models.Ewallet;
import com.eshopping.profile.userprofile.repositories.ProfileRepository;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@Service
public class ProfileEwalletService {
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	ProfileRepository profileRepo;
	
	// calling EWallet-Service for creating wallet for new user using newly generated profileId
	@HystrixCommand(fallbackMethod = "getFallbackAddWalletForProfile",
			commandProperties = {
					@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000"),
					@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),
					@HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
					@HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000"),
			}
			)
	
	public Ewallet addWalletForProfile(String profileId) {
		String uri = "http://ewallet-service/ewallet/addForProfile/" + profileId;
				
		
		return restTemplate.postForObject(uri, null, Ewallet.class);
	}
	
	public Ewallet getFallbackAddWalletForProfile(String profileId) {
		profileRepo.deleteById(profileId);
		return new Ewallet(profileId, 0, new ArrayList<String>());
	}
}
