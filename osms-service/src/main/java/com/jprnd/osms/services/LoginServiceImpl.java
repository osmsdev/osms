package com.jprnd.osms.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jprnd.osms.dao.LoginDao;
import com.jprnd.osms.model.AuthModel;

@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	private LoginDao loginDao;
	
	@Override
	public boolean dummy(){
		System.out.println("From Service - Calling dummy!!!");
		loginDao.dummy();
		return true;
	}

	@Override
	public AuthModel login(String username, String password) throws Exception{
		if("admin".equalsIgnoreCase(username) && "admin123".equals(password)){
			return new AuthModel("lakflsfljl12j1j23jkljlsdjfs");
		}
		throw new Exception();
	}

	
}
