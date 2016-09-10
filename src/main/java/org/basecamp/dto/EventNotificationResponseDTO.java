package org.basecamp.dto;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonProperty;
import org.basecamp.util.OptionalParam;

public class EventNotificationResponseDTO implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@JsonProperty(value = "success")
	private String success;
	
	@JsonProperty(value = "errorCode")
	private String errorCode;
	
	@JsonProperty(value = "message")
	private String message;
	
	@JsonProperty(value = "accountIdentifier")
	private String accountIdentifier;

	public String getSuccess() {
		return success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getAccountIdentifier() {
		return accountIdentifier;
	}

	public void setAccountIdentifier(String accountIdentifier) {
		this.accountIdentifier = accountIdentifier;
	}

	@Override
	public String toString() {
		return "EventNotificationResponseDTO [success=" + success + ", errorCode=" + errorCode + ", message=" + message
				+ ", accountIdentifier=" + accountIdentifier + "]";
	}

}
