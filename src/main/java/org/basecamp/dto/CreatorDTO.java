package org.basecamp.dto;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonProperty;
import org.basecamp.util.OptionalParam;

public class CreatorDTO implements Serializable 
{
	
	private static final long serialVersionUID = 1L;

	@JsonProperty(value = "address")
	private AddressDTO address;

	@JsonProperty(value = "email")
	private String email;

	@OptionalParam
	@JsonProperty(value = "firstName")
	private String firstName;

	@OptionalParam
	@JsonProperty(value = "language")
	private String language;

	@OptionalParam
	@JsonProperty(value = "lastName")
	private String lastName;

	@OptionalParam
	@JsonProperty(value = "openId")
	private String openId;

	@OptionalParam
	@JsonProperty(value = "uuid")
	private String uuid;
	
	public AddressDTO getAddress() {
		return address;
	}

	public void setAddress(AddressDTO address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	@Override
	public String toString() {
		return "Creator [address=" + address + ", email=" + email + ", firstName=" + firstName + ", language="
				+ language + ", lastName=" + lastName + ", openId=" + openId + ", uuid=" + uuid + "]";
	}

}
