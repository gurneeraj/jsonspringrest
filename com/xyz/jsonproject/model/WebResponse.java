package com.xyz.jsonproject.model;

public class WebResponse {
	
	private String requestId;
	
	private String userId;
	
	private String clientId;
	
	public WebResponse() {
		
	}

	public WebResponse(String requestId, String userId, String clientId) {
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
		return "WebResponse [requestId=" + requestId + ", userId=" + userId + ", clientId=" + clientId + "]";
	}
	
}
