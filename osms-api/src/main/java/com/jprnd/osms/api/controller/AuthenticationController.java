package com.jprnd.osms.api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jprnd.osms.api.req.AuthRequest;
import com.jprnd.osms.api.util.ApiErrorCode;
import com.jprnd.osms.api.util.ApiErrorUtil;
import com.jprnd.osms.exception.AuthenticationException;
import com.jprnd.osms.exception.RequiredValidationException;
import com.jprnd.osms.model.AuthModel;
import com.jprnd.osms.model.ViewModel;
import com.jprnd.osms.services.LoginService;

@RestController
public class AuthenticationController extends AbstractBaseController  {

	private static final Logger logger = LoggerFactory.getLogger(AuthenticationController.class);

    @Autowired
    private LoginService loginService;
    
    @RequestMapping(value = AUTHENTICATE, method = RequestMethod.POST)
    public ViewModel authenticate(@RequestBody AuthRequest input) {
    	logger.debug("start--->" + "authenticate " );
    	try {
    		
    		checkPreCondition(input.getUsername(), input.getPassword());
    		
        	AuthModel model = loginService.login(input.getUsername(), input.getPassword());
        	
        	logger.debug("End--->" + " authenticate" + " params-->" );
        	
        	return model;
        	
    	}catch(AuthenticationException ae){
    		return ApiErrorUtil.buildErrorModel(ApiErrorCode.AuthError,ae.getMessage());
    	}catch(RequiredValidationException ae){
    		return ApiErrorUtil.buildErrorModel(ApiErrorCode.ValidationError,ae.getMessage());
        }catch(Exception e){
        	return ApiErrorUtil.buildErrorModel(ApiErrorCode.SystemError,getMessage("error.system.error.message"));
        }
    	
       
    }
	 
	 private void checkPreCondition(String username, String password) throws RequiredValidationException{
		 if( StringUtils.isEmpty(username) || StringUtils.isEmpty(password) ){
			 throw new RequiredValidationException(getMessage("error.username.password.required"));
		 }
	 }
}
