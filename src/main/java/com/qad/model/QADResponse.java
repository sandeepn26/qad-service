package com.qad.model;

public class QADResponse {

	private String displayMsg;

	private String referenceId;

	private String message;

	private String code;

	public String getDisplayMsg() {
		return displayMsg;
	}

	public void setDisplayMsg(String displayMsg) {
		this.displayMsg = displayMsg;
	}

	public String getReferenceId() {
		return referenceId;
	}

	public void setReferenceId(String referenceId) {
		this.referenceId = referenceId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static class Builder {
		private String displayMsg;

		private String referenceId;

		private String message;

		private String code;

		public Builder withDisplayMsg(String displayMsg) {
			this.displayMsg = displayMsg;
			return this;
		}

		public Builder withReferenceId(String referenceId) {
			this.referenceId = referenceId;
			return this;
		}

		public Builder withMessage(String message) {
			this.message = message;
			return this;
		}

		public Builder withCode(String code) {
			this.code = code;
			return this;
		}

		public QADResponse build() {
			QADResponse response = new QADResponse();
			response.setCode(code);
			response.setDisplayMsg(displayMsg);
			response.setMessage(message);
			response.setReferenceId(referenceId);
			return response;
		}
	}
	
	//++++++ Standard Responses +++++++++++++++//
	
	public static final QADResponse LOGIN_SUCCESS = builder().withMessage("Login Success").build();
	
	public static final QADResponse TEAM_CREATED = builder().withMessage("Team Created").build();
	
	public static final QADResponse MEMBER_CREATED = builder().withMessage("Member Created").build();
	
	public static final QADResponse MEMBER_UPDATED = builder().withMessage("Member Updated").build();
	
	public static final QADResponse MEMBER_DEACTIVATED = builder().withMessage("Member Deactivated").build();
	
	public static final QADResponse UNAUTHORIZED = builder().withMessage("Unauthorized").withCode("UNAUTHORIZED").build();
}
