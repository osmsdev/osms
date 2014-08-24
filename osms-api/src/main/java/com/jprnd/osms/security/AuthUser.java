package com.jprnd.osms.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.jprnd.osms.model.UserModel;

public class AuthUser implements UserDetails {

	private String userName;
	private String password;
	private String email;
	private String firstName;
	private String lastName;
	private String token;
	
	
	
	public AuthUser(UserModel model){
		this.password = model.getPassword();
		this.userName = model.getUsername();
		this.email = model.getEmail();
		this.firstName = model.getFirstName();
		this.lastName = model.getLastName();
	}
	
	public String getFirstName(){
		return this.firstName;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getUsername() {
		return this.userName;
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
		return true;
	}

	

}
