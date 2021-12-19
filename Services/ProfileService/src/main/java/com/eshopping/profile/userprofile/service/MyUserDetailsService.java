package com.eshopping.profile.userprofile.service;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.eshopping.profile.userprofile.models.CustomUserDetails;
import com.eshopping.profile.userprofile.models.UserProfile;
import com.eshopping.profile.userprofile.repositories.ProfileRepository;

//import java.util.ArrayList;
import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	ProfileRepository profileRepo;
	
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	// username will contain to email
    	Optional<UserProfile> userProfile =  profileRepo.findByEmail(username);
        
    	userProfile.orElseThrow(()-> new UsernameNotFoundException("User with email " + username + " not found!"));
    	
        return userProfile.map(CustomUserDetails::new).get();        	
      
        // return new User(username, "Pass@123", new ArrayList<>());
    }
}