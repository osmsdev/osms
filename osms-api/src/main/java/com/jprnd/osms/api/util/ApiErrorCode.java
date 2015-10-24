package com.jprnd.osms.api.util;

public enum ApiErrorCode {

	AuthError("AUTH_ERROR"), SystemError("SYSTEM_ERROR");

	String code;

	ApiErrorCode(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}
}
