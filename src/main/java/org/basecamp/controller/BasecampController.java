package org.basecamp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.Header;
import org.basecamp.constant.ErrorCodeEum;
import org.basecamp.core.HttpClientWrapper;
import org.basecamp.dto.EventNotificationRequestDTO;
import org.basecamp.dto.EventNotificationResponseDTO;
import org.basecamp.util.BasecampUtil;
import org.basecamp.util.HttpHeaderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * Basecamp controller is designed to handle SusbcriptionEvent notification if triggered.
 * @author amans
 *
 */
@Controller
public class BasecampController {	
	
	@Autowired
	private BasecampUtil basecampUtil;
	
	 /**
	  * This controller is responsible for maintaining Subscription State of user. 
	  * All event Notification related to subscription is handled by this controller
	  * After authenticate user, the pathVariable contains {@code eventUrl} 
	  * which gets called and convert it json response to object and process it further.
	  * 
     * @param request - HTTPServletRequest
     * @param eventUrl - a url to call to get user subscription details in response
     * @return {@code json} - return statusCode with message in json format
     */
	@RequestMapping( value = "/event/notification", produces = "application/json; charset=utf-8" , method = RequestMethod.GET)
	public @ResponseBody String getSubscriptionEventNotification(HttpServletRequest request,
			@RequestParam(value = "url", required=true) String eventUrl)
	{
		//TODO: user authentication should be in the filter
		EventNotificationResponseDTO responseDTO = null;
		
		if(StringUtils.isBlank(eventUrl))
		{
			responseDTO = new EventNotificationResponseDTO();
			responseDTO.setSuccess("false");
			responseDTO.setErrorCode(ErrorCodeEum.INVALID_RESPONSE.name());
			responseDTO.setMessage(ErrorCodeEum.INVALID_RESPONSE.getName());
			return basecampUtil.createAndSendJsonResponse(responseDTO);
		}
		EventNotificationRequestDTO requestDTO = null;
		
		List<Header> headers = HttpHeaderUtil.getHeaderList(request);
		requestDTO = HttpClientWrapper.executeGetRequest(null, eventUrl, headers, EventNotificationRequestDTO.class);
		
		if(basecampUtil.isRequiredParametersMissing(requestDTO))
		{
			responseDTO = new EventNotificationResponseDTO();
			responseDTO.setSuccess("false");
			responseDTO.setErrorCode(ErrorCodeEum.INVALID_RESPONSE.name());
			responseDTO.setMessage(ErrorCodeEum.INVALID_RESPONSE.getName());
			return basecampUtil.createAndSendJsonResponse(responseDTO);
		}
		
		responseDTO = basecampUtil.checkCreateOrUpdateSubscriptionInDB(requestDTO);
		return basecampUtil.createAndSendJsonResponse(responseDTO);
	}
	
}
