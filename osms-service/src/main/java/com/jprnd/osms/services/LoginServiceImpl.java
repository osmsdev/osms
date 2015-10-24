package com.jprnd.osms.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jprnd.osms.dao.LoginDao;
import com.jprnd.osms.entity.UserEntity;
import com.jprnd.osms.exception.AuthenticationException;
import com.jprnd.osms.model.ApiInfoModel;
import com.jprnd.osms.model.AuthModel;
import com.jprnd.osms.model.UserModel;

@Service
public class LoginServiceImpl extends BaseService implements LoginService{

	private static final Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);
	
	@Autowired
	private LoginDao loginDao;
	
	@Override
	public AuthModel login(String username, String password) throws AuthenticationException{
		logger.debug("start--->" + "login" + " params-->" + username +", "+ password);
		
		UserEntity user = loginDao.login(username, password);
		
		if(user != null){
			logger.debug("Authentication successfull");
			return new AuthModel("lakflsfljl12j1j23jkljlsdjfs"); //TODO
		}
		
		logger.error("Authentication failed");
		
		throw new AuthenticationException(getMessage("error.user.not.found")); //TODO
	}

	@Override
	public UserModel findUser(String userName) throws Exception {
		UserModel model = new UserModel();
		UserEntity user = loginDao.findUser(userName);
		
		if(user != null){
			BeanUtils.copyProperties(user, model);
		}
		return model;
	}

	@Override
	public ApiInfoModel getApiInfo() {
		return new ApiInfoModel(getApiVersion());
	}

	private String getApiVersion(){
		//TODO--- Write logic to get API Version
		return "1.0";
	}
	
}
