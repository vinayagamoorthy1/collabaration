package com.niit.collabaration.model;

import javax.persistence.Transient;

public class BaseDomain {
	@Transient
	private String errorCode;
	private String errormessage;
	public String getErrormessage() {
		return errormessage;
	}
	public void setErrormessage(String errormessage) {
		this.errormessage = errormessage;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

}
