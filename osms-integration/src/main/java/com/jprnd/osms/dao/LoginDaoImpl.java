package com.jprnd.osms.dao;

import org.springframework.stereotype.Service;

@Service
public class LoginDaoImpl implements LoginDao{

	@Override
	public boolean dummy() {
		System.out.println("From DAO - calling dummy");
		return false;
	}

}
