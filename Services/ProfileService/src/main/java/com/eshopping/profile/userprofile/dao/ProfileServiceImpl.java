package com.eshopping.profile.userprofile.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.eshopping.profile.userprofile.models.Address;
import com.eshopping.profile.userprofile.models.AuthenticationResponse;
import com.eshopping.profile.userprofile.models.Ewallet;
import com.eshopping.profile.userprofile.models.Role;
import com.eshopping.profile.userprofile.models.UserProfile;
import com.eshopping.profile.userprofile.repositories.ProfileRepository;

@Service
public class ProfileServiceImpl implements ProfileService {
	@Autowired
	ProfileRepository profileRepo;
	
	@Autowired
	ProfileEwalletService ewalletService;
	
	@Autowired
	PasswordEncoder passEncoder;
	
	@Override
	public UserProfile addNewCustomerProfile(UserProfile cp) {
		// checking if user with same email id already exists
		Optional<UserProfile> existedUser = profileRepo.findByEmail(cp.getEmail());
		if(existedUser.isPresent()) {
			return new UserProfile();
		}
		
		cp.setRole(Role.Customer);
		
		// encode password
		cp.setPassword(passEncoder.encode(cp.getPassword()));
		
		// setting addresses list as empty
		cp.setAddresses(new ArrayList<Address>());
		
		// save resultant user to database
		UserProfile userPro = profileRepo.save(cp);	
		
		System.out.println(cp);
		
//		// calling EWallet-Service for creating wallet for new user using newly generated profileId
//		Ewallet newWallet = ewalletService.addWalletForProfile(userPro.getProfileId());
//		System.out.println(newWallet);
//		
//		if(newWallet.getWalletId() == null) {
//			userPro = new UserProfile();
//		}
		
		// TODO create cart
		
		return userPro; 
	}

	@Override
	public UserProfile addNewMerchantProfile(UserProfile mp) {
		mp.setRole(Role.Merchant);
		return profileRepo.save(mp); 
	}

	@Override
	public UserProfile addNewDeliveryProfile(UserProfile dp) {
		dp.setRole(Role.DeliveryAgent);
		return profileRepo.save(dp); 
	}

	@Override
	public List<UserProfile> getAllProfiles() {
		return profileRepo.findAll();
	}

	@Override
	public Optional<UserProfile> getByProfileId(String id) {
		return profileRepo.findById(id);
	}

	@Override
	public UserProfile updateProfile(UserProfile up) {
		return profileRepo.save(up);
	}

	@Override
	public String deleteProfile(String id) {
		profileRepo.deleteById(id);
		return "Profile Deleted";
	}

	@Override
	public Optional<UserProfile> findByMobileNumber(long mobileNumber) {
		return profileRepo.findByMobileNumber(mobileNumber);
	}

	@Override
	public Optional<UserProfile> getByUserName(String email) {
		return profileRepo.findByEmail(email);
	}

}
