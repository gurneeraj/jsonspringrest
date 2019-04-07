package com.xyz.jsonproject.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.xyz.jsonproject.model.UserRequest;
import com.xyz.jsonproject.model.UserResponse;
import com.xyz.jsonproject.service.UserService;

/**
 * @author gurneerajsinghdahele
 *
 */
@RestController
public class ApplcationController {
	
	@Autowired
	UserService userService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ApplcationController.class);
	
	/**
	 * Code for "/accountCreation" endpoint
	 * This method sends the User request data to UserService and returns UserResponse in Json format
	 * 
	 * @param UserRequest gets populated by JSon data 
	 * @return UserResponse object
	 */
	@PostMapping(path = "/accountCreation", consumes = "application/json", produces = "application/json")
	public ResponseEntity<UserResponse> accountCreation(@Valid @RequestBody UserRequest userRequest) {
		
		LOGGER.info("Inside controller's accountCreation(): Before service call: Name: "+ userRequest.getName()+" RequestId: "+userRequest.getRequestId());
		LOGGER.debug("Inside controller's accountCreation(): "+ userRequest);
		
		UserResponse returnedUser = userService.accountCreation(userRequest);
		
		LOGGER.info("Inside controller's accountCreation(): After service call: Name: "+ returnedUser.getName()+" RequestId: "+returnedUser.getRequestId()+" ApplicationId: "+returnedUser.getApplicationId());
		
		return new ResponseEntity<>(returnedUser,HttpStatus.CREATED);
		
	}
	
}
