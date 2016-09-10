package org.basecamp.dto;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonProperty;
import org.basecamp.constant.EventUsedEnum;
import org.basecamp.constant.StatusTypeEnum;
import org.basecamp.util.OptionalParam;

public class EventNotificationRequestDTO implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	 @JsonProperty(value = "type")
	 private StatusTypeEnum type;
	 
	 @JsonProperty(value = "marketplace")
	 private MarketPlaceDTO marketplace;
	 
	 @OptionalParam
	 @JsonProperty(value = "applicationUuid")
	 private String applicationUuid;
	 
	 @OptionalParam
	 @JsonProperty(value = "flag")
	 private EventUsedEnum flag;
	 
	 @OptionalParam
	 @JsonProperty(value = "returnUrl")
	 private String returnUrl;
	 
	 @JsonProperty(value = "creater")
	 private CreatorDTO creater;
	 
	 @JsonProperty(value = "payload")
	 private PayloadDTO payload;

	public StatusTypeEnum getType() {
		return type;
	}

	public void setType(StatusTypeEnum type) {
		this.type = type;
	}

	public MarketPlaceDTO getMarketplace() {
		return marketplace;
	}

	public void setMarketplace(MarketPlaceDTO marketplace) {
		this.marketplace = marketplace;
	}

	public CreatorDTO getCreater() {
		return creater;
	}

	public void setCreater(CreatorDTO creater) {
		this.creater = creater;
	}

	public PayloadDTO getPayload() {
		return payload;
	}

	public void setPayload(PayloadDTO payload) {
		this.payload = payload;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "EventNotificationRequestDTO [type=" + type + ", marketplace=" + marketplace + ", creater=" + creater
				+ ", payload=" + payload + "]";
	}
	 

}
