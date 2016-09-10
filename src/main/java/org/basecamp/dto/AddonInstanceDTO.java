package org.basecamp.dto;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonProperty;

public class AddonInstanceDTO implements Serializable
{
	
	private static final long serialVersionUID = 1L;
	
	@JsonProperty(value = "id")
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "AddonInstanceDTO [id=" + id + "]";
	}
	
	
}
