package org.basecamp.util;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.basecamp.business.BasecampBO;
import org.basecamp.constant.ErrorCodeEum;
import org.basecamp.constant.StatusTypeEnum;
import org.basecamp.dto.EventNotificationRequestDTO;
import org.basecamp.dto.EventNotificationResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BasecampUtil 
{

	@Autowired
	private BasecampBO basecampBO;
	
	/**
	 * @param responseDTO - this is a EventNotificationResponseDTO which is prepared to notify 
	 * ThirdParty about subscription State
	 * @return {@code json} - return json response from given object
	 */
	public String createAndSendJsonResponse(EventNotificationResponseDTO responseDTO) 
	{
		ObjectMapper mapper = new ObjectMapper();
		String jsonInString="";
		try {
			jsonInString = mapper.writeValueAsString(responseDTO);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	    return jsonInString;
	}

	/**
	 * @param requestDTO - a requestDTO converted from JSON to Object contains user subscription information.
	 * @return {@code boolean} - return false if required parameters are not available as per the contract
	 */
	public boolean isRequiredParametersMissing(EventNotificationRequestDTO requestDTO) {
		//TODO: need to check if required parameters present or not. If not return false
		return false;
	}

	/**
	 * This method process user specific subscription and respond to the event
	 * @param requestDTO - 
	 * @return {@code responseDTO} - response of the subscription event
	 */
	public EventNotificationResponseDTO checkCreateOrUpdateSubscriptionInDB(EventNotificationRequestDTO requestDTO) 
	{
		StatusTypeEnum subscriptionStatus = requestDTO.getType();
		EventNotificationResponseDTO responseDTO = null;
		
		switch(subscriptionStatus)
		{
		case SUBSCRIPTION_ORDER:
			responseDTO =  basecampBO.createUserAccount(requestDTO);
			break;
		case SUBSCRIPTION_CANCEL:
			responseDTO =  basecampBO.cancelUserAccount(requestDTO);
			break;
		default:
			//TODO: need to handle all other Subscription Status as well
			break;
		}
		return responseDTO;
		
	}

	
}
