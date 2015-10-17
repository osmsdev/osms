package com.jprnd.osms.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jprnd.osms.entity.UserEntity;

@Service
public interface LoginDao {
	boolean dummy();
	List<UserEntity> login(String userName, String password);
}
