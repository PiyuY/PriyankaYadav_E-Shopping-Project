package com.eshopping.profile.userprofile.dao;

import java.util.List;
import java.util.Optional;

import com.eshopping.profile.userprofile.models.UserProfile;

public interface ProfileService {

	public UserProfile addNewCustomerProfile(UserProfile cp);
	public UserProfile addNewMerchantProfile(UserProfile mp);
	public UserProfile addNewDeliveryProfile(UserProfile dp);	
	public List<UserProfile> getAllProfiles();
	public Optional<UserProfile> getByProfileId(String id); 
	public UserProfile updateProfile(UserProfile up);
	public String deleteProfile(String id);
	public Optional<UserProfile> findByMobileNumber(long mobileNumber);
	public Optional<UserProfile> getByUserName(String email);
	
	
}
