package com.jprnd.osms.model;

public class BaseModel implements ViewModel{

	private String status;

	public BaseModel(String status){
		this.status = status;
	}
	
	public String getStatus() {
		return status;
	}
	
	
}
