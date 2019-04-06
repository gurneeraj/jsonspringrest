package com.amreen.jsonproject.service;

import com.amreen.jsonproject.model.UserRequest;
import com.amreen.jsonproject.model.UserResponse;

/**
 * @author gurneerajsinghdahele
 *
 */
public interface UserService {

	UserResponse accountCreation(UserRequest user);
}
