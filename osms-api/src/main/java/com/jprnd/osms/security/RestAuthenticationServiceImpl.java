package com.jprnd.osms.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.jprnd.osms.model.UserModel;
import com.jprnd.osms.services.LoginService;


public class RestAuthenticationServiceImpl implements UserDetailsService{
	   @Autowired
	    private LoginService loginService;
		
	@Override
	public UserDetails loadUserByUsername(String userName)
			throws UsernameNotFoundException {
		//TODO  - 
		System.out.println("loadUserByUsername");
		UserModel model = null;
		try {
			model = loginService.findUser(userName);
		} catch (Exception e) {
			throw new UsernameNotFoundException("User not found.");
		}
		
		if(model == null){
			throw new UsernameNotFoundException("User not found.");
		}
		
		AuthUser user = new AuthUser(model);
		
		return user;
	}

	

}
