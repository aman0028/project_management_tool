package org.basecamp.dto;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonProperty;
import org.basecamp.constant.NoticeTypeEnum;
import org.basecamp.util.OptionalParam;

public class NoticeDTO implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@JsonProperty(value = "type")
	private NoticeTypeEnum type;
	
	@OptionalParam
	@JsonProperty(value = "message")
	private String message;

	public NoticeTypeEnum getType() {
		return type;
	}

	public void setType(NoticeTypeEnum type) {
		this.type = type;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "NoticeDTO [type=" + type + ", message=" + message + "]";
	}
	

}
