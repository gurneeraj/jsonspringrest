package com.xyz.jsonproject.model;

/**
 * @author gurneerajsinghdahele
 *
 */
public class UserResponse extends WebResponse{

	private String applicationId;

	private String name;

	private String username;

	private String email;

	private String phone;

	public UserResponse() {

	}

	public UserResponse(String requestId, String userId, String clientId, String applicationId, String name, String username, String email, String phone) {
		super(requestId, userId, clientId);
		this.applicationId = applicationId;
		this.name = name;
		this.username = username;
		this.email = email;
		this.phone = phone;
		
	}
	
	public String getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String userName) {
		this.username = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "UserResponse [applicationId=" + applicationId + ", name=" + name + ", username=" + username + ", email="
				+ email + ", phone=" + phone + "]";
	}
	
}
