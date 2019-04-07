package com.xyz.jsonproject.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.xyz.jsonproject.model.UserRequest;
import com.xyz.jsonproject.model.UserResponse;

/**
 * @author gurneerajsinghdahele
 *
 */
@Service
public class UserServiceImpl implements UserService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
	
	/* 
	 * Logs the UserRequest and returns UserResponse
	 */
	@Override
	public UserResponse accountCreation(UserRequest userRequest) {
		
		// This code generates random number for application id.
		String applicationId = Integer.toString((int) (Math.random()*100));
		
		LOGGER.info("Inside service's accountCreation(): Name: "+ userRequest.getName()+" RequestId: "+userRequest.getRequestId());
		LOGGER.debug("Inside service's accountCreation():  "+ userRequest);
		
		// This code is emulating a fetch from database and returning UserResponse data with application id.
		// UserResponse will only display RequestId, UserId, ClientId, ApplicationId, Name, Username, Email and Phone
		UserResponse userResponse = new UserResponse();
		userResponse.setRequestId(userRequest.getRequestId());
		userResponse.setUserId(userRequest.getUserId());
		userResponse.setClientId(userRequest.getClientId());	
		userResponse.setApplicationId(applicationId );
		userResponse.setName(userRequest.getName());
		userResponse.setUsername(userRequest.getUsername());
		userResponse.setEmail(userRequest.getEmail());
		userResponse.setPhone(userRequest.getPhone());
		
		LOGGER.info("Inside service's accountCreation(): Name: "+ userResponse.getName()+" RequestId: "+userResponse.getRequestId()+" ApplicationId:"+userResponse.getApplicationId());
		LOGGER.debug("Inside service's accountCreation():  "+ userResponse);
		
		return userResponse;
	}
}
