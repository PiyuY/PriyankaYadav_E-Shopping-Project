package com.eshopping.profile.userprofile.models;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUserDetails implements UserDetails {
	
	private String username;
	private String password;
	private List<SimpleGrantedAuthority> authorities;
	private boolean active;

	public CustomUserDetails(UserProfile user) {
		this.username = user.getEmail();
		this.password = user.getPassword();
		this.authorities = Arrays.asList(new SimpleGrantedAuthority(user.getRole().name()));
		this.active = true;
	}
	
	public CustomUserDetails() {
		
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return active;
	}
	
}
