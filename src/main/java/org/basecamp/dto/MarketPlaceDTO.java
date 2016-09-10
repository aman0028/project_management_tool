package org.basecamp.dto;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonProperty;

public class MarketPlaceDTO implements Serializable
{
	private static final long serialVersionUID = 1L;

	@JsonProperty(value = "baseUrl")
	private String baseUrl;
	
	@JsonProperty(value = "partner")
	private String partner;

	public String getBaseUrl() {
		return baseUrl;
	}

	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}

	public String getPartner() {
		return partner;
	}

	public void setPartner(String partner) {
		this.partner = partner;
	}

	@Override
	public String toString() {
		return "MarketPlace [baseUrl=" + baseUrl + ", partner=" + partner + "]";
	}

}
