package org.basecamp.dto;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonProperty;

public class addonBindingDTO implements Serializable
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

	@Override
	public String toString() {
		return "addonBindingDTO [id=" + id + "]";
	}

}
