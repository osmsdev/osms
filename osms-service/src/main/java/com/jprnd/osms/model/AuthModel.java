package com.jprnd.osms.model;

public class AuthModel extends BaseModel{

	private String token;
	
	public AuthModel(String token){
		super(STATUS_OK);
		this.token = token;
	}

	public String getToken() {
		return token;
	}
	
	
}
