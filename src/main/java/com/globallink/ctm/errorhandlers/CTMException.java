package com.globallink.ctm.errorhandlers;

public class CTMException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private CTMError ctmError;
	
	public CTMException(CTMError ctmError) {
		super();
		this.ctmError = ctmError;
	}
	
	public CTMException(CTMError ctmError, String message) {
		super(message);
		this.ctmError = ctmError;
	}
	
	public CTMException(CTMError ctmError, String message, Throwable cause) {
		super(message, cause);
		this.ctmError = ctmError;
	}
	
	public CTMException(CTMError ctmError, Throwable cause) {
		super(cause);
		this.ctmError = ctmError;
	}

	public CTMError getCtmError() {
		return ctmError;
	}

	public void setCtmError(CTMError ctmError) {
		this.ctmError = ctmError;
	}
	
}
