package com.qad.exceptions;

import org.springframework.http.HttpStatus;

import com.qad.model.QADResponse;

public class QADServiceException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private QADResponse errorResponse;
	
	private HttpStatus httpStatus = HttpStatus.FORBIDDEN;

	public QADResponse getErrorResponse() {
		return errorResponse;
	}

	public void setErrorResponse() {
		errorResponse = QADResponse.builder().withMessage(getCause().getMessage()).build();
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public QADServiceException() {
		setErrorResponse();
	}

	public QADServiceException(String arg0) {
		super(arg0);
		setErrorResponse();
	}

	public QADServiceException(Throwable arg0) {
		super(arg0);
		setErrorResponse();
	}

	public QADServiceException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		setErrorResponse();
	}

	public QADServiceException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		setErrorResponse();
	}
	
	public QADServiceException(Throwable arg0, HttpStatus httpStatus) {
		super(arg0);
		setErrorResponse();
	}

	public QADServiceException(String arg0, Throwable arg1, HttpStatus httpStatus) {
		super(arg0, arg1);
		setErrorResponse();
	}

}
