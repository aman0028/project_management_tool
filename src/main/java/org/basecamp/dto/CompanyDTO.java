package org.basecamp.dto;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonProperty;
import org.basecamp.util.OptionalParam;

public class CompanyDTO implements Serializable
{
	private static final long serialVersionUID = 1L;

	@JsonProperty(value = "uuid")
	private String uuid;
	
	@OptionalParam
	@JsonProperty(value = "externalId")
	private String externalId;
	
	@JsonProperty(value = "name")
	private String name;
	
	@JsonProperty(value = "email")
	private String email;
	
	@JsonProperty(value = "phoneNumber")
	private String phoneNumber;
	
	@JsonProperty(value = "website")
	private String website;
	
	@OptionalParam
	@JsonProperty(value = "country")
	private String country;

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getExternalId() {
		return externalId;
	}

	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "CompanyDTO [uuid=" + uuid + ", externalId=" + externalId + ", name=" + name + ", email=" + email
				+ ", phoneNumber=" + phoneNumber + ", website=" + website + ", country=" + country + "]";
	}

}
