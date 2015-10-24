package com.jprnd.osms.api.controller;

public interface ResourceURL {

	String URL_PREFIX_SYSTEM = "/api/system";
	String AUTHENTICATE = URL_PREFIX_SYSTEM + "/authenticate";
	String API_INFO = URL_PREFIX_SYSTEM + "/apiinfo";

	String API_URL = "/api";
	String GET_USER = API_URL + "/user";
	
}
