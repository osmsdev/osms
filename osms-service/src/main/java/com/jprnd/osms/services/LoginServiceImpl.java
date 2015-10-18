package com.jprnd.osms.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jprnd.osms.dao.LoginDao;
import com.jprnd.osms.entity.UserEntity;
import com.jprnd.osms.model.AuthModel;
import com.jprnd.osms.model.UserModel;

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
		UserEntity user = loginDao.login(username, password);
		if(user != null){
			return new AuthModel("lakflsfljl12j1j23jkljlsdjfs"); //TODO
		}
		throw new Exception("User not found."); //TODO
	}

	@Override
	public UserModel findUser(String userName) throws Exception {
		UserModel model = new UserModel();
		model.setFirstName("Admin");
		model.setUsername("admin");
		model.setPassword("admin123");
		model.setEmail("admin@jprnd.com");
		return model;
	}

	
}
