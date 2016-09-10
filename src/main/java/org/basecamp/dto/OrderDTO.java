package org.basecamp.dto;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonProperty;
import org.basecamp.util.OptionalParam;

public class OrderDTO implements Serializable
{
	private static final long serialVersionUID = 1L;

	@JsonProperty(value = "editionCode")
	private String editionCode;
	
	@OptionalParam
	@JsonProperty(value = "addonOfferingCode")
	private String addonOfferingCode;
	
	@JsonProperty(value = "pricingDuration")
	private String pricingDuration;
	
	@JsonProperty(value = "addonInstance")
	private AddonInstanceDTO addonInstance;
	
	@JsonProperty(value = "addonBinding")
	private addonBindingDTO addonBinding;
	
	@JsonProperty(value = "notice")
	private NoticeDTO notice;

	public String getEditionCode() {
		return editionCode;
	}

	public void setEditionCode(String editionCode) {
		this.editionCode = editionCode;
	}

	public String getAddonOfferingCode() {
		return addonOfferingCode;
	}

	public void setAddonOfferingCode(String addonOfferingCode) {
		this.addonOfferingCode = addonOfferingCode;
	}

	public String getPricingDuration() {
		return pricingDuration;
	}

	public void setPricingDuration(String pricingDuration) {
		this.pricingDuration = pricingDuration;
	}

	public AddonInstanceDTO getAddonInstance() {
		return addonInstance;
	}

	public void setAddonInstance(AddonInstanceDTO addonInstance) {
		this.addonInstance = addonInstance;
	}

	public addonBindingDTO getAddonBinding() {
		return addonBinding;
	}

	public void setAddonBinding(addonBindingDTO addonBinding) {
		this.addonBinding = addonBinding;
	}

	public NoticeDTO getNotice() {
		return notice;
	}

	public void setNotice(NoticeDTO notice) {
		this.notice = notice;
	}

	@Override
	public String toString() {
		return "OrderDTO [editionCode=" + editionCode + ", addonOfferingCode=" + addonOfferingCode
				+ ", pricingDuration=" + pricingDuration + ", addonInstance=" + addonInstance + ", addonBinding="
				+ addonBinding + ", notice=" + notice + "]";
	}
	
}
