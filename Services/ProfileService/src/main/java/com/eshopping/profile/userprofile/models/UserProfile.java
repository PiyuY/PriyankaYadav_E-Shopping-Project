package com.eshopping.profile.userprofile.models;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("UserProfile")
public class UserProfile {
	@Id
	private String profileId;
	private String fullName;
	private String image;
	private String email;
	private long mobileNumber;
	private String about;
	private LocalDate dateOfBirth;
	private String gender;
	private Role role;
	private String password;
	private List<Address> addresses; 
	
	//Default Constructor
	public UserProfile() {}
	
	//Parameterized Constructor
	public UserProfile(String profileId, String fullName, String image, String email, long mobileNumber, String about,
			LocalDate dateOfBirth, String gender, Role role, String password, List<Address> addresses) {
		super();
		this.profileId = profileId;
		this.fullName = fullName;
		this.image = image;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.about = about;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.role = role;
		this.password = password;
		this.addresses = addresses;
	}
	
	@Override
	public String toString() {
		return "UserProfile [profileId=" + profileId + ", fullName=" + fullName + ", image=" + image + ", email="
				+ email + ", mobileNumber=" + mobileNumber + ", about=" + about + ", dateOfBirth=" + dateOfBirth
				+ ", gender=" + gender + ", role=" + role + ", password=" + password + ", addresses=" + addresses + "]";
	}

	public String getProfileId() {
		return profileId;
	}

	public void setProfileId(String profileId) {
		this.profileId = profileId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	@Override
	public int hashCode() {
		return Objects.hash(about, addresses, dateOfBirth, email, fullName, gender, image, mobileNumber, password,
				profileId, role);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserProfile other = (UserProfile) obj;
		return Objects.equals(about, other.about) && Objects.equals(addresses, other.addresses)
				&& Objects.equals(dateOfBirth, other.dateOfBirth) && Objects.equals(email, other.email)
				&& Objects.equals(fullName, other.fullName) && Objects.equals(gender, other.gender)
				&& Objects.equals(image, other.image) && mobileNumber == other.mobileNumber
				&& Objects.equals(password, other.password) && Objects.equals(profileId, other.profileId)
				&& role == other.role;
	}
	
	
			
}
