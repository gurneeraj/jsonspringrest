package com.amreen.jsonproject.model;

import org.hibernate.validator.constraints.NotEmpty;

public class WebRequest {
	
	@NotEmpty(message = "RequestId is mandatory")
	private String requestId;
	
	@NotEmpty(message = "UserId is mandatory")
	private String userId;
	
	@NotEmpty(message = "ClientId is mandatory")
	private String clientId;
	
	public WebRequest() {
		
	}
	
	public WebRequest(String requestId, String userId, String clientId) {
		super();
		this.requestId = requestId;
		this.userId = userId;
		this.clientId = clientId;
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	@Override
	public String toString() {
		return "WebRequest [requestId=" + requestId + ", userId=" + userId + ", clientId=" + clientId + "]";
	}
	
}
