package org.basecamp.dto;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonProperty;

public class PayloadDTO implements Serializable
{
	private static final long serialVersionUID = 1L;

	@JsonProperty(value = "user")
	private CreatorDTO user;
	
	@JsonProperty(value = "accountIdentifierder")
	private String accountIdentifier;
	
	@JsonProperty(value = "status")
	private String status;
	
	@JsonProperty(value = "company")
	private CompanyDTO company;
	
	@JsonProperty(value = "order")
	private OrderDTO order;

	public CreatorDTO getUser() {
		return user;
	}

	public void setUser(CreatorDTO user) {
		this.user = user;
	}

	public String getAccountIdentifier() {
		return accountIdentifier;
	}

	public void setAccountIdentifier(String accountIdentifier) {
		this.accountIdentifier = accountIdentifier;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public CompanyDTO getCompany() {
		return company;
	}

	public void setCompany(CompanyDTO company) {
		this.company = company;
	}

	public OrderDTO getOrder() {
		return order;
	}

	public void setOrder(OrderDTO order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return "PayloadDTO [user=" + user + ", accountIdentifier=" + accountIdentifier + ", status=" + status
				+ ", company=" + company + ", order=" + order + "]";
	}
}
