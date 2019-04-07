package com.xyz.jsonproject.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
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
	
	Address address;
	Company company;
	UserRequest userRequest;
	UserResponse userResponse;
	
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	UserService userService;
	
	@Before
	public void intializeEntities() {
		address = new Address("Victor Plains", "Suite 879", "Wisokyburgh", "90566-7771");
		company = new Company("Deckow-Crist", "Proactive didactic contingency",
				"synergize scalable supply-chains");
		userRequest = new UserRequest("99","77","88", "Eeeee", "Anfdf", "Sh@annissa.tv", address, "010-692-6593",
				"nastasia.net", company);
		userResponse = new UserResponse("99","77","88","100", "Eeeee", "Anfdf", "Sh@annissa.tv", "010-692-6593");
	}

	/**
	 * Method tests the 201 HttpStatus on accountCreation() method in ApplicationController class 
	 * and the output with expected result
	 * 
	 * @throws Exception
	 */
	@Test
	public void accountCreation() throws Exception {
		
		assertResult(HttpStatus.CREATED.value(), userRequest, asJsonString(userResponse));
	}
	
	/**
	 * Method tests the 400 HttpStatus on missing address.city in JSon and the output with expected result
	 *
	 * @throws Exception
	 */
	@Test
	public void accountCreationAddressCityMissing() throws Exception {
		userRequest.getAddress().setCity(null);
		String errorResponse = "{\"status\":\"400\",\"address.city\":\"City name is mandatory\"}";
		assertResult(HttpStatus.BAD_REQUEST.value(), userRequest, errorResponse);
	}
	
	/**
	 * Method tests the 400 HttpStatus on missing address in JSon and the output with expected result
	 *
	 * @throws Exception
	 */
	@Test
	public void accountCreationAddressMissing() throws Exception {
		userRequest .setAddress(null);
		String errorResponse = "{\"status\":\"400\",\"address\":\"Address is mandatory\"}";
		assertResult(HttpStatus.BAD_REQUEST.value(), userRequest, errorResponse);
	}
	
	/**
	 * Method tests the 400 HttpStatus on missing company in JSon and the output with expected result
	 *
	 * @throws Exception
	 */
	@Test
	public void accountCreationCompanyMissing() throws Exception {
		userRequest .setCompany(null);
		String errorResponse = "{\"status\":\"400\",\"company\":\"Company is mandatory\"}";
		assertResult(HttpStatus.BAD_REQUEST.value(), userRequest, errorResponse);
	}
	
	/**
	 * Method tests the 400 HttpStatus on missing company.name in JSon and the output with expected result
	 *
	 * @throws Exception
	 */
	@Test
	public void accountCreationCompanyNameMissing() throws Exception {
		userRequest.getCompany().setName(null);
		String errorResponse = "{\"status\":\"400\",\"company.name\":\"Company name is mandatory\"}";
		assertResult(HttpStatus.BAD_REQUEST.value(), userRequest, errorResponse);
	}
	
	/**
	 * Method tests the 400 HttpStatus on empty JSon and the output with expected result
	 *
	 * @throws Exception
	 */
	@Test
	public void accountCreationEmptyJSon() throws Exception {
		String errorResponse = "{\"status\":\"400\"}";
		assertResult(HttpStatus.BAD_REQUEST.value(), new UserRequest(), errorResponse);
	}
	
	/**
	 * Method tests the 400 HttpStatus on missing requestId in JSon and the output with expected result
	 *
	 * @throws Exception
	 */
	@Test
	public void accountCreationUserRequestRequestIdMissing() throws Exception {
		userRequest.setRequestId(null);
		String errorResponse = "{\"status\":\"400\",\"requestId\":\"RequestId is mandatory\"}";
		assertResult(HttpStatus.BAD_REQUEST.value(), userRequest, errorResponse);
	}
	
	/**
	 * Method tests the 400 HttpStatus on missing name in JSon and the output with expected result
	 *
	 * @throws Exception
	 */
	@Test
	public void accountCreationUserRequestNameMissing() throws Exception {
		userRequest.setName(null);
		String errorResponse = "{\"status\":\"400\",\"name\":\"Name is mandatory\"}";
		assertResult(HttpStatus.BAD_REQUEST.value(), userRequest, errorResponse);
	}
	
	/**
	 * Method tests the 400 HttpStatus on missing Username in JSon and the output with expected result
	 *
	 * @throws Exception
	 */
	@Test
	public void accountCreationUserRequestUserNameMissing() throws Exception {
		userRequest.setUsername(null);
		String errorResponse = "{\"status\":\"400\",\"username\":\"Username is mandatory\"}";
		assertResult(HttpStatus.BAD_REQUEST.value(), userRequest, errorResponse);
	}
	
	/**
	 * Method tests the 400 HttpStatus on missing phone in JSon and the output with expected result
	 *
	 * @throws Exception
	 */
	@Test
	public void accountCreationUserRequestPhoneMissing() throws Exception {
		userRequest.setPhone(null);
		String errorResponse = "{\"status\":\"400\",\"phone\":\"Phone is mandatory\"}";
		assertResult(HttpStatus.BAD_REQUEST.value(), userRequest, errorResponse);
	}
	
	/**
	 * Method tests the 400 HttpStatus on missing name and phone in JSon and the output with expected result
	 *
	 * @throws Exception
	 */
	@Test
	public void accountCreationUserRequestNamenPhoneMissing() throws Exception {
		userRequest.setName(null);
		userRequest.setPhone(null);
		String errorResponse = "{\"status\":\"400\",\"name\":\"Name is mandatory\", \"phone\":\"Phone is mandatory\"}";
		assertResult(HttpStatus.BAD_REQUEST.value(), userRequest, errorResponse);
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
	 * Method tests the various test-cases based on input parameters
	 *
	 * @param userRequest : UserRequest for different test cases
	 * @param expectedStatus: Expected status for different test cases
	 * @param expectedResult: Expected result for different test cases
	 * @throws Exception
	 *
	 */
	private void assertResult(int expectedStatus, UserRequest userRequest, String expectedResult) throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/accountCreation").accept(MediaType.APPLICATION_JSON)
				.content(asJsonString(userRequest)).contentType(MediaType.APPLICATION_JSON);
		
		Mockito.when(userService.accountCreation(Mockito.any(UserRequest.class))).thenReturn(userResponse);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();

		assertEquals(expectedStatus, response.getStatus());
		
		JSONAssert.assertEquals(expectedResult, result.getResponse()
				.getContentAsString(), JSONCompareMode.LENIENT);
	}

}
