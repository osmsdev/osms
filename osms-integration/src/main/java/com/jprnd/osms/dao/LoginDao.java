package com.jprnd.osms.dao;

import org.springframework.stereotype.Service;

import com.jprnd.osms.entity.UserEntity;

@Service
public interface LoginDao {
	UserEntity login(String userName, String password);

	UserEntity findUser(String username);
}
