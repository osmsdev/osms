package com.jprnd.osms.services;

import org.springframework.stereotype.Service;

import com.jprnd.osms.model.AuthModel;
import com.jprnd.osms.model.UserModel;

@Service
public interface LoginService {

	boolean dummy();
	
	AuthModel login(String username, String password) throws Exception;
	
	UserModel findUser(String userName) throws Exception;
	
	
}
