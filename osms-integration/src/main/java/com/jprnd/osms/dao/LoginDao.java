package com.jprnd.osms.dao;

import org.springframework.stereotype.Service;

import com.jprnd.osms.entity.UserEntity;

@Service
public interface LoginDao {
	boolean dummy();
	UserEntity login(String userName, String password);
}
