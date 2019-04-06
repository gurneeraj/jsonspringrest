package com.xyz.jsonproject.service;

import com.xyz.jsonproject.model.UserRequest;
import com.xyz.jsonproject.model.UserResponse;

/**
 * @author gurneerajsinghdahele
 *
 */
public interface UserService {

	UserResponse accountCreation(UserRequest user);
}
