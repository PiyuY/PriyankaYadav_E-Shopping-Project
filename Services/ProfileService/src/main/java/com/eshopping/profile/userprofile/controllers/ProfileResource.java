package com.eshopping.profile.userprofile.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eshopping.profile.userprofile.dao.ProfileService;
import com.eshopping.profile.userprofile.models.UserProfile;

@RestController
@RequestMapping("/profile")
@CrossOrigin(origins = "*")
public class ProfileResource {
	
	@Autowired
	ProfileService proService;
		
	@PostMapping("/customer/add")
	public UserProfile addNewCustomerProfile(@RequestBody UserProfile cp) {	
		return proService.addNewCustomerProfile(cp);
	}
	
	@PostMapping("/merchant/add")
	public UserProfile addNewMerchantProfile(@RequestBody UserProfile mp) {
		return proService.addNewMerchantProfile(mp);
	}
	
	@PostMapping("/delivery/add")
	public UserProfile addNewDeliveryProfile(@RequestBody UserProfile dp) {
		return proService.addNewDeliveryProfile(dp);
	}
	
	@GetMapping("/all")
	public List<UserProfile> getAllProfiles(){
		return proService.getAllProfiles();
		
	}
	
	@GetMapping("/byid/{id}")
	public Optional<UserProfile> getByProfileId(@PathVariable("id") String id){
		return proService.getByProfileId(id);
	}
	
	@PutMapping("/update")
	public UserProfile updateProfile(@RequestBody UserProfile up) {
		return proService.updateProfile(up);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteProfile(@PathVariable("id") String id) {
		return proService.deleteProfile(id);
	}
	
	@GetMapping("/bymobile/{mobileNumber}")
	public Optional<UserProfile> findByMobileNumber(@PathVariable("mobileNumber") long mobileNumber){
		return proService.findByMobileNumber(mobileNumber);
	}
	
	@GetMapping("/byemail/{email}")
	public Optional<UserProfile> getByUserName(@PathVariable("email") String email){
		System.out.println(email);
		return proService.getByUserName(email);
	}
	
}
