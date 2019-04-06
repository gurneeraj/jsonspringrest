package com.amreen.jsonproject.controller;

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

import com.amreen.jsonproject.model.Address;
import com.amreen.jsonproject.model.Company;
import com.amreen.jsonproject.model.UserRequest;
import com.amreen.jsonproject.model.UserResponse;
import com.amreen.jsonproject.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author gurneerajsinghdahele
 *
 */
@RunWith(SpringRunner.class)
@WebMvcTest(value = ApplcationController.class)
public class UserControllerTest {

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
		Address address = new Address("Victor Plains", "Suite 879", "Wisokyburgh", "90566-7771");
		Company company = new Company("Deckow-Crist", "Proactive didactic contingency",
				"synergize scalable supply-chains");
		UserRequest userRequest = new UserRequest("99","77","88", "Eeeee", "Anfdf", "Sh@annissa.tv", address, "010-692-6593",
				"nastasia.net", company);
		UserResponse userResponse = new UserResponse("99","77","88","100", "Eeeee", "Anfdf", "Sh@annissa.tv", "010-692-6593");
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/accountCreation").accept(MediaType.APPLICATION_JSON)
				.content(asJsonString(userRequest)).contentType(MediaType.APPLICATION_JSON);

		Mockito.when(userService.accountCreation(Mockito.any(UserRequest.class))).thenReturn(userResponse);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();

		assertEquals(HttpStatus.CREATED.value(), response.getStatus());
		
	}
	
	@Test
	public void accountCreationAddressCityMissing() throws Exception {
		Address address = new Address("Victor Plains", "Suite 879", null, "90566-7771");
		Company company = new Company("Deckow-Crist", "Proactive didactic contingency",
				"synergize scalable supply-chains");
		UserRequest userRequest = new UserRequest("99","77","88", "Eeeee", "Anfdf", "Sh@annissa.tv", address, "010-692-6593",
				"nastasia.net", company);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/accountCreation").accept(MediaType.APPLICATION_JSON)
				.content(asJsonString(userRequest)).contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();

		assertEquals(HttpStatus.BAD_REQUEST.value(), response.getStatus());	
	}
	
	@Test
	public void accountCreationAddressMissing() throws Exception {

		Company company = new Company("Deckow-Crist", "Proactive didactic contingency",
				"synergize scalable supply-chains");
		UserRequest userRequest = new UserRequest("99","77","88", "Eeeee", "Anfdf", "Sh@annissa.tv", null, "010-692-6593",
				"nastasia.net", company);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/accountCreation").accept(MediaType.APPLICATION_JSON)
				.content(asJsonString(userRequest)).contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();

		assertEquals(HttpStatus.BAD_REQUEST.value(), response.getStatus());	
	}
	
	@Test
	public void accountCreationCompanyMissing() throws Exception {
		Address address = new Address("Victor Plains", "Suite 879", "Wisokyburgh", "90566-7771");
	
		UserRequest userRequest = new UserRequest("99","77","88", "Eeeee", "Anfdf", "Sh@annissa.tv", address, "010-692-6593",
				"nastasia.net", null);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/accountCreation").accept(MediaType.APPLICATION_JSON)
				.content(asJsonString(userRequest)).contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();

		assertEquals(HttpStatus.BAD_REQUEST.value(), response.getStatus());	
	}
	
	@Test
	public void accountCreationCompanyNameMissing() throws Exception {
		Address address = new Address("Victor Plains", "Suite 879", "Wisokyburgh", "90566-7771");
	
		Company company = new Company(null, "Proactive didactic contingency",
				"synergize scalable supply-chains");
		
		UserRequest userRequest = new UserRequest("99","77","88", "Eeeee", "Anfdf", "Sh@annissa.tv", address, "010-692-6593",
				"nastasia.net", company);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/accountCreation").accept(MediaType.APPLICATION_JSON)
				.content(asJsonString(userRequest)).contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();

		assertEquals(HttpStatus.BAD_REQUEST.value(), response.getStatus());	
	}
	
	@Test
	public void accountCreationEmptyJSon() throws Exception {
		
		UserRequest userRequest = new UserRequest();
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/accountCreation").accept(MediaType.APPLICATION_JSON)
				.content(asJsonString(userRequest)).contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();

		assertEquals(HttpStatus.BAD_REQUEST.value(), response.getStatus());	
	}
	
	@Test
	public void accountCreationUserRequestRequestIdMissing() throws Exception {
		Address address = new Address("Victor Plains", "Suite 879", "Wisokyburgh", "90566-7771");
	
		Company company = new Company(null, "Proactive didactic contingency",
				"synergize scalable supply-chains");
		
		UserRequest userRequest = new UserRequest(null,"77","88", "Eeeee", "Anfdf", "Sh@annissa.tv", address, "010-692-6593",
				"nastasia.net", company);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/accountCreation").accept(MediaType.APPLICATION_JSON)
				.content(asJsonString(userRequest)).contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();

		assertEquals(HttpStatus.BAD_REQUEST.value(), response.getStatus());	
	}
	
	@Test
	public void accountCreationUserRequestNameMissing() throws Exception {
		Address address = new Address("Victor Plains", "Suite 879", "Wisokyburgh", "90566-7771");
	
		Company company = new Company(null, "Proactive didactic contingency",
				"synergize scalable supply-chains");
		
		UserRequest userRequest = new UserRequest("99","77","88", null, "Anfdf", "Sh@annissa.tv", address, "010-692-6593",
				"nastasia.net", company);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/accountCreation").accept(MediaType.APPLICATION_JSON)
				.content(asJsonString(userRequest)).contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();

		assertEquals(HttpStatus.BAD_REQUEST.value(), response.getStatus());	
	}
	
	@Test
	public void accountCreationUserRequestUserNameMissing() throws Exception {
		Address address = new Address("Victor Plains", "Suite 879", "Wisokyburgh", "90566-7771");
	
		Company company = new Company(null, "Proactive didactic contingency",
				"synergize scalable supply-chains");
		
		UserRequest userRequest = new UserRequest("99","77","88", "Eeeee", null, "Sh@annissa.tv", address, "010-692-6593",
				"nastasia.net", company);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/accountCreation").accept(MediaType.APPLICATION_JSON)
				.content(asJsonString(userRequest)).contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();

		assertEquals(HttpStatus.BAD_REQUEST.value(), response.getStatus());	
	}
	
	@Test
	public void accountCreationUserRequestPhoneMissing() throws Exception {
		Address address = new Address("Victor Plains", "Suite 879", "Wisokyburgh", "90566-7771");
	
		Company company = new Company(null, "Proactive didactic contingency",
				"synergize scalable supply-chains");
		
		UserRequest userRequest = new UserRequest("99","77","88", "Eeeee", "Anfdf", "Sh@annissa.tv", address, null,
				"nastasia.net", company);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/accountCreation").accept(MediaType.APPLICATION_JSON)
				.content(asJsonString(userRequest)).contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();

		assertEquals(HttpStatus.BAD_REQUEST.value(), response.getStatus());	
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

}
