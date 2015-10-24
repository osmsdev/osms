package com.jprnd.osms.services;

import org.springframework.beans.factory.annotation.Autowired;

public class BaseService {

	@Autowired
	protected AppMessageResourceService messageSource;

	protected String getMessage(String key) {
		return messageSource.getMessage(key);
	}

	protected String getMessage(String key, Object[] message) {
		return messageSource.getMessage(key, message);
	}

}
