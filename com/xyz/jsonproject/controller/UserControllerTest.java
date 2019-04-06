package com.xyz.jsonproject.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xyz.jsonproject.controller.ApplcationController;
import com.xyz.jsonproject.model.Address;
import com.xyz.jsonproject.model.Company;
import com.xyz.jsonproject.model.UserRequest;
import com.xyz.jsonproject.model.UserResponse;
import com.xyz.jsonproject.service.UserService;

/**
 * @author gurneerajsinghdahele
 *
 */
@RunWith(SpringRunner.class)
@WebMvcTest(value = ApplcationController.class)
public class UserControllerTest {
	
	Address address = new Address("Victor Plains", "Suite 879", "Wisokyburgh", "90566-7771");
	Company company = new Company("Deckow-Crist", "Proactive didactic contingency",
			"synergize scalable supply-chains");
	UserRequest userRequest = new UserRequest("99","77","88", "Eeeee", "Anfdf", "Sh@annissa.tv", address, "010-692-6593",
			"nastasia.net", company);
	UserResponse userResponse = new UserResponse("99","77","88","100", "Eeeee", "Anfdf", "Sh@annissa.tv", "010-692-6593");

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	UserService userService;

	/**
	 * Method tests the accountCreation() method in ApplicationController class
	 * 
	 * @throws Exception
	 */
	@Test
	public void accountCreation() throws Exception {
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/accountCreation").accept(MediaType.APPLICATION_JSON)
				.content(asJsonString(userRequest)).contentType(MediaType.APPLICATION_JSON);

		Mockito.when(userService.accountCreation(Mockito.any(UserRequest.class))).thenReturn(userResponse);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();

		assertEquals(HttpStatus.CREATED.value(), response.getStatus());
		
	}
	
	@Test
	public void accountCreationAddressCityMissing() throws Exception {
		userRequest.getAddress().setCity(null);
		
		assertResult(userRequest);	
	}
	
	@Test
	public void accountCreationAddressMissing() throws Exception {

		userRequest.setAddress(null);
		
		assertResult(userRequest);	
	}
	
	@Test
	public void accountCreationCompanyMissing() throws Exception {
		userRequest.setCompany(null);
		
		assertResult(userRequest);	
	}
	
	@Test
	public void accountCreationCompanyNameMissing() throws Exception {
		userRequest.getCompany().setName(null);
		
		assertResult(userRequest);	
	}
	
	@Test
	public void accountCreationEmptyJSon() throws Exception {
		
		assertResult(new UserRequest());	
	}
	
	@Test
	public void accountCreationUserRequestRequestIdMissing() throws Exception {
		userRequest.setRequestId(null);
		
		assertResult(userRequest);	
	}
	
	@Test
	public void accountCreationUserRequestNameMissing() throws Exception {
		
		userRequest.setName(null);
		
		assertResult(userRequest);
	}
	
	@Test
	public void accountCreationUserRequestUserNameMissing() throws Exception {
		userRequest.setUsername(null);
		
		assertResult(userRequest);	
	}
	
	@Test
	public void accountCreationUserRequestPhoneMissing() throws Exception {
		userRequest.setPhone(null);
		
		assertResult(userRequest);
	}
	
	@Test
	public void accountCreationUserRequestPhonenNameMissing() throws Exception {
		userRequest.setPhone(null);
		userRequest.setName(null);
		
		assertResult(userRequest);
	}

	/**
	 * Method returns String representation of JSon based on object passed
	 * 
	 * @param obj input object for JSon output
	 * @return string representation of JSon
	 */
	private static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * @param userRequest takes as input
	 * @throws Exception
	 */
	private void assertResult(UserRequest userRequest) throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/accountCreation").accept(MediaType.APPLICATION_JSON)
				.content(asJsonString(userRequest)).contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();

		assertEquals(HttpStatus.BAD_REQUEST.value(), response.getStatus());
	}

}
