package com.jprnd.osms.services;

import org.springframework.stereotype.Service;

import com.jprnd.osms.exception.AuthenticationException;
import com.jprnd.osms.model.ApiInfoModel;
import com.jprnd.osms.model.AuthModel;
import com.jprnd.osms.model.UserModel;

@Service
public interface LoginService {

	AuthModel login(String username, String password) throws AuthenticationException;
	
	UserModel findUser(String userName) throws Exception;
	
	ApiInfoModel getApiInfo();
	
}
