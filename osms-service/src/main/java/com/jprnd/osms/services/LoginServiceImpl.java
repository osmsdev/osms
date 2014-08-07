package com.jprnd.osms.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jprnd.osms.dao.LoginDao;

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
	
}
