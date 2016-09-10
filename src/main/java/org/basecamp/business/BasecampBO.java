package org.basecamp.business;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import org.apache.commons.lang3.StringUtils;
import org.basecamp.constant.ErrorCodeEum;
import org.basecamp.dao.BasecampDAO;
import org.basecamp.dto.EventNotificationRequestDTO;
import org.basecamp.dto.EventNotificationResponseDTO;
import org.basecamp.entity.UserAccountEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BasecampBO 
{
	@Autowired
	private BasecampDAO basecampDAO;

	/**
	 * This method create new user entry in DB and respond the user state
	 * @param requestDTO - user specific subscription data
	 * @return responseDTO - response of the user creation event
	 */
	public EventNotificationResponseDTO createUserAccount(EventNotificationRequestDTO requestDTO) 
	{
		UserAccountEntity entity = new UserAccountEntity();
		String identifierId = getUniqueId();
		entity.setIdentiferId(identifierId);
		entity.setSubscriptionStatus(requestDTO.getType().name());
		
		Date date = new Date(System.currentTimeMillis());
		entity.setDateCreated(date);
		
		entity.setFullName(requestDTO.getCreater().getFirstName() + " "+ requestDTO.getCreater().getLastName());
		entity.setUserEmailId(requestDTO.getCreater().getEmail());
		entity.setCompanyName(requestDTO.getPayload().getCompany().getName());
		entity.setCompanyPhoneNumber(requestDTO.getPayload().getCompany().getPhoneNumber());
		entity.setCompanyWebsite(requestDTO.getPayload().getCompany().getWebsite());
		entity.setOrderEditionCode(requestDTO.getPayload().getOrder().getEditionCode());
		entity.setPriceDuration(requestDTO.getPayload().getOrder().getPricingDuration());
		
		basecampDAO.saveUserAccount(entity);
		
		EventNotificationResponseDTO responseDTO = new EventNotificationResponseDTO();
		responseDTO.setSuccess("true");
		responseDTO.setAccountIdentifier(identifierId);
		responseDTO.setErrorCode(ErrorCodeEum.SUCCESS.name());
		responseDTO.setMessage(ErrorCodeEum.SUCCESS.getName());
		return responseDTO;
	}

	/**
	 * This method generates unique IdentifierId.
	 * @return identifierId
	 */
	private String getUniqueId() {
		Calendar cal = Calendar.getInstance();
		int constantValueForAWeek = 
				(cal.get(Calendar.YEAR) - 2000 ) * 53 + cal.get(Calendar.WEEK_OF_YEAR) + cal.get(Calendar.DAY_OF_MONTH);
		Random rand = new Random();
		long drand = (long)(rand.nextDouble()*10000000000L);
		StringBuilder buf = new StringBuilder();
		buf.append(constantValueForAWeek);
		buf.append(drand);
		return buf.toString();
	}

	/**
	 * This method update user triggered cancel subscription event in DB.
	 * @param requestDTO - user specific subscription data
	 * @return responseDTO - response of the user subscription cancel state event
	 */
	public EventNotificationResponseDTO cancelUserAccount(EventNotificationRequestDTO requestDTO) 
	{
		EventNotificationResponseDTO responseDTO = new EventNotificationResponseDTO();
		UserAccountEntity userAccountEntity = 
				basecampDAO.findUserAccountById(requestDTO.getPayload().getAccountIdentifier());
		if(null == userAccountEntity ||
				!StringUtils.equals(userAccountEntity.getIdentiferId(), requestDTO.getPayload().getAccountIdentifier()))
		{
			responseDTO.setSuccess("false");
			responseDTO.setErrorCode(ErrorCodeEum.ACCOUNT_NOT_FOUND.name());
			responseDTO.setMessage(ErrorCodeEum.ACCOUNT_NOT_FOUND.getName());
			return responseDTO;
		}
		
		userAccountEntity.setSubscriptionStatus(requestDTO.getType().name());
		
		Date date = new Date(System.currentTimeMillis());
		userAccountEntity.setDateCreated(date);
		
		basecampDAO.updateUserAccount(userAccountEntity);
		
		responseDTO.setSuccess("true");
		responseDTO.setErrorCode(ErrorCodeEum.SUCCESS.name());
		responseDTO.setMessage(ErrorCodeEum.SUCCESS.getName());
		return responseDTO;
	}

}
