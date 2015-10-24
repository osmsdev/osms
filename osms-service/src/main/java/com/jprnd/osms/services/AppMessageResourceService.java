package com.jprnd.osms.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Service;


@Service
public class AppMessageResourceService {

	@Autowired
	protected ReloadableResourceBundleMessageSource messageSource;

	public String getMessage(String key) {
		try{
			return messageSource.getMessage(key, null,LocaleContextHolder.getLocale());
		}catch(Exception e){
			e.printStackTrace();
		}
		return key;
	}

	public String getMessage(String key, Object[] message) {
		try{
			return messageSource.getMessage(key, message,LocaleContextHolder.getLocale());
		}catch(Exception e){
			e.printStackTrace();
		}
		return key;
	}
}
