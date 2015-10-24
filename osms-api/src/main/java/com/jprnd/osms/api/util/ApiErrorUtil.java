package com.jprnd.osms.api.util;

import com.jprnd.osms.model.ErrorModel;

public class ApiErrorUtil {

	
	public static ErrorModel buildErrorModel(ApiErrorCode code, String message){
		return  new ErrorModel(code.getCode(),message);
	}
	
}
