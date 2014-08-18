package com.jprnd.osms.api.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping(value = SystemResource.API_URL)
public abstract class AbstractBaseResource {
	static final String API_URL = "/api";

    public static final String PARAM_SECURITY_TOKEN = "security_token";
    protected static final String PATH_VAR_ID = "id";

    protected static final ResponseEntity<String> NOT_FOUND = new ResponseEntity(HttpStatus.NOT_FOUND);
    protected static final ResponseEntity<String> NO_CONTENT = new ResponseEntity(HttpStatus.NO_CONTENT);
    protected static final ResponseEntity<String> INTERNAL_ERROR = new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);

    public static final String USER_REQ_ATTR = "__USER";

    protected final Log logger;

 
    protected AbstractBaseResource() {
        logger = LogFactory.getLog(getClass());
    }

    protected ResponseEntity<String> generateOk(final String responseBody) {
        return new ResponseEntity(responseBody, HttpStatus.OK);
    }

    

    
}
