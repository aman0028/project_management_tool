package org.basecamp.dto;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonProperty;
import org.basecamp.util.OptionalParam;

public class AddressDTO implements Serializable
{
	private static final long serialVersionUID = 1L;

	@JsonProperty(value = "city")
	private String city;
	
	@JsonProperty(value = "country")
	private String country;
	
	@OptionalParam
	@JsonProperty(value = "state")
	private String state;
	
	@JsonProperty(value = "street1")
	private String street1;
	
	@OptionalParam
	@JsonProperty(value = "street2")
	private String street2;
	
	@JsonProperty(value = "zip")
	private String zip;


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getStreet1() {
		return street1;
	}


	public void setStreet1(String street1) {
		this.street1 = street1;
	}


	public String getStreet2() {
		return street2;
	}


	public void setStreet2(String street2) {
		this.street2 = street2;
	}


	public String getZip() {
		return zip;
	}


	public void setZip(String zip) {
		this.zip = zip;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public String toString() {
		return "AddressDTO [city=" + city + ", country=" + country + ", state=" + state + ", street1=" + street1
				+ ", street2=" + street2 + ", zip=" + zip + "]";
	}

}
