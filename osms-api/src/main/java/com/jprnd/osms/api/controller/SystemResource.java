package com.jprnd.osms.api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jprnd.osms.model.ApiInfoModel;
import com.jprnd.osms.services.LoginService;

@RestController
public class SystemResource extends AbstractBaseController {
    
	private static final Logger logger = LoggerFactory.getLogger(SystemResource.class);
	
    @Autowired
    private LoginService loginService;

    @RequestMapping(value = API_INFO, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiInfoModel getApiInfo() {
    	logger.debug("Get API Version");
    
    	return loginService.getApiInfo();
    }
    
    /**
     * Some requests do not require authentication.
     */
    public static boolean isAuthenticationRequired(final String requestURI) {
        return !(requestURI.endsWith(API_INFO) || requestURI.endsWith(AUTHENTICATE));
    	//return !(requestURI.endsWith(API_INFO) || requestURI.endsWith(AUTHENTICATE) || requestURI.endsWith(REPORT));
    }

}
