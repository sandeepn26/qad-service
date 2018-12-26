package com.lps.errorhandlers;

import java.util.Optional;

public class CTMErrorBuilder {

	private String errorDetails;

	private String errorCode;

	private Optional<String> httpStatusCode;

	private Optional<Integer> ctmStatusCode;

	public CTMErrorBuilder withErrorDetails(String errorDetails) {
		this.errorDetails = errorDetails;
		return this;
	}

	public CTMErrorBuilder withErrorCode(String errorCode) {
		this.errorCode = errorCode;
		return this;
	}

	public CTMErrorBuilder withHttpStatusCode(Optional<String> httpStatusCode) {
		this.httpStatusCode = httpStatusCode;
		return this;
	}

	
	public CTMErrorBuilder withCtmStatusCode(Optional<Integer> ctmStatusCode) {
		this.ctmStatusCode = ctmStatusCode;
		return this;
	}

	public CTMError build() {
		CTMError ctmError = new CTMError(errorCode, errorDetails);
		ctmStatusCode.ifPresent(ctmError::setCtmStatusCode);
		httpStatusCode.ifPresent(ctmError::setHttpStatusCode);
		
		return ctmError;
	}
}
