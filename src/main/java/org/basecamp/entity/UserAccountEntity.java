package org.basecamp.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity
@Table(name="user_accounts")
public class UserAccountEntity implements Serializable
{
		@Id
		@Column(name = "user_identifer_id")
		private String identiferId;
		
		@Column(name = "fullname")
		private String fullName;
		
		@Column(name = "user_email_id")
		private String userEmailId;
		
		@Column(name = "company_name")
		private String companyName;
		
		@Column(name = "company_website")
		private String companyWebsite;  
		
		@Column(name = "company_phone_number")
		private String companyPhoneNumber;  
		
		@Column(name = "order_edition_code")
		private String orderEditionCode; 
		
		@Column(name = "price_duration")
		private String priceDuration;
		
		@Column(name = "subscription_status")
		private String subscriptionStatus;
		
		@Temporal(TemporalType.TIMESTAMP)
	    @Column(name = "date_created")
	    private Date dateCreated;

	    @Temporal(TemporalType.TIMESTAMP)
	    @Column(name = "date_updated")
	    private Date dateUpdated;
		
		public String getIdentiferId() {
			return identiferId;
		}

		public void setIdentiferId(String identiferId) {
			this.identiferId = identiferId;
		}

		public String getFullName() {
			return fullName;
		}

		public void setFullName(String fullName) {
			this.fullName = fullName;
		}

		public String getUserEmailId() {
			return userEmailId;
		}

		public void setUserEmailId(String userEmailId) {
			this.userEmailId = userEmailId;
		}

		public String getCompanyName() {
			return companyName;
		}

		public void setCompanyName(String companyName) {
			this.companyName = companyName;
		}

		public String getCompanyWebsite() {
			return companyWebsite;
		}

		public void setCompanyWebsite(String companyWebsite) {
			this.companyWebsite = companyWebsite;
		}

		public String getCompanyPhoneNumber() {
			return companyPhoneNumber;
		}

		public void setCompanyPhoneNumber(String companyPhoneNumber) {
			this.companyPhoneNumber = companyPhoneNumber;
		}

		public String getOrderEditionCode() {
			return orderEditionCode;
		}

		public void setOrderEditionCode(String orderEditionCode) {
			this.orderEditionCode = orderEditionCode;
		}

		public String getPriceDuration() {
			return priceDuration;
		}

		public void setPriceDuration(String priceDuration) {
			this.priceDuration = priceDuration;
		}

		public String getSubscriptionStatus() {
			return subscriptionStatus;
		}

		public void setSubscriptionStatus(String subscriptionStatus) {
			this.subscriptionStatus = subscriptionStatus;
		}
		
		public Date getDateCreated() {
			return dateCreated;
		}

		public void setDateCreated(Date dateCreated) {
			this.dateCreated = dateCreated;
		}

		public Date getDateUpdated() {
			return dateUpdated;
		}

		public void setDateUpdated(Date dateUpdated) {
			this.dateUpdated = dateUpdated;
		}

		@Override
		public String toString() {
			return "UserAccountEntity [identiferId=" + identiferId + ", fullName=" + fullName + ", userEmailId="
					+ userEmailId + ", companyName=" + companyName + ", companyWebsite=" + companyWebsite
					+ ", companyPhoneNumber=" + companyPhoneNumber + ", orderEditionCode=" + orderEditionCode
					+ ", priceDuration=" + priceDuration + ", subscriptionStatus=" + subscriptionStatus + "]";
		}

}
