package com.jprnd.osms.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.bind.annotation.RestController;

import com.jprnd.osms.services.AppMessageResourceService;


@RestController
public abstract class AbstractBaseController implements ResourceURL{

	@Autowired
	protected AppMessageResourceService messageSource;
	 
    protected AbstractBaseController() {

    }
    
	protected String getMessage(String key) {
		return messageSource.getMessage(key);
	}

	protected String getMessage(String key, Object[] message) {
		return messageSource.getMessage(key, message);
	}

    
}
