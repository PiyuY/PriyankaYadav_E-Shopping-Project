package com.eshopping.profile.userprofile.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.eshopping.profile.userprofile.models.UserProfile;

public interface ProfileRepository extends MongoRepository<UserProfile, String> {

	Optional<UserProfile> findByMobileNumber(long mobileNumber);

	Optional<UserProfile> findByEmail(String email);

}
