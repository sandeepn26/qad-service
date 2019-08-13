package com.qad.errorhandlers;

public class CTMError {

	public static final int CLS_REPONSE_ERROR = 1;

	private String errorDetails;

	private String errorCode;

	private String httpStatusCode;

	private int ctmStatusCode;

	public CTMError(String errorCode, String errorDetails) {
		this.errorCode = errorCode;
		this.errorDetails = errorDetails;
	}

	public CTMError() {

	}

	public String getErrorDetails() {
		return errorDetails;
	}

	public void setErrorDetails(String errorDetails) {
		this.errorDetails = errorDetails;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getHttpStatusCode() {
		return httpStatusCode;
	}

	public void setHttpStatusCode(String httpStatusCode) {
		this.httpStatusCode = httpStatusCode;
	}

	public int getCtmStatusCode() {
		return ctmStatusCode;
	}

	public void setCtmStatusCode(int ctmStatusCode) {
		this.ctmStatusCode = ctmStatusCode;
	}
}
