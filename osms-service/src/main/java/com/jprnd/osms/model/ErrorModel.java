package com.jprnd.osms.model;

public class ErrorModel extends BaseModel {
	private String errorCode;
	private String errorDescription;

	public ErrorModel() {
		super(STATUS_FAILED);
	}

	public ErrorModel(String errorCode, String errorDescription) {
		super(STATUS_FAILED);
		this.errorCode = errorCode;
		this.errorDescription = errorDescription;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public String getErrorDescription() {
		return errorDescription;
	}

}
