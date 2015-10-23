package com.jprnd.osms.api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jprnd.osms.model.AuthModel;
import com.jprnd.osms.services.LoginService;

@Controller
@RequestMapping(value = SystemResource.URL_PREFIX_SYSTEM)
public class SystemResource extends AbstractBaseResource {
    
	private static final Logger logger = LoggerFactory.getLogger(SystemResource.class);
	
	 

	
	static final String URL_PREFIX_SYSTEM = "/api/system";
    

    private static final String API_VERSION = "2.0";
    	
    private static final String AUTHENTICATE = "/authenticate";
    private static final String API_INFO = "/apiinfo";

    public static final String USER_PARAM = "user";
    private static final String PASSWORD_PARAM = "password";

    // package scope for accessibility from unit-tests
    int securityTokenExpirationSec;

   
    @Autowired
    private LoginService loginService;

   

    @RequestMapping(value = API_INFO, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<String> getApiInfo() {
    	System.out.println("CAlling ApiInfo");
    	loginService.dummy();
        return generateOk("{ \"api_version\":\"" + API_VERSION + "\" }");
    }
    
    
    @RequestMapping(value = AUTHENTICATE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> authenticate(@RequestParam("username") final String userName, @RequestParam("password") final String password) {
    	logger.debug("start--->" + "authenticate" + " params-->" + userName,password);
    	try {
        	
        	AuthModel model = loginService.login(userName, password);
        	logger.debug("End--->" + " authenticate" + " params-->" + userName + password );
        	return generateOk("{ \"token\":\"" + model.getToken() + "\" }");
        	 
        }catch(Exception e){
        	return generateOk("{ \"error\":\" Invalid username or password. \" }");
        }
    	
       
    }

    /**
     * Some requests do not require authentication.
     */
    public static boolean isAuthenticationRequired(final String requestURI) {
        return !(requestURI.endsWith(API_INFO) || requestURI.endsWith(AUTHENTICATE));
    	//return !(requestURI.endsWith(API_INFO) || requestURI.endsWith(AUTHENTICATE) || requestURI.endsWith(REPORT));
    }

}
