package com.amreen.jsonproject.model;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * All fields are validated using hibernate validation api
 * 
 * @author gurneerajsinghdahele
 *
 */
public class UserRequest extends WebRequest {

	@NotEmpty(message = "Name is mandatory")
	@Size(min = 4, message = "Name should have atleast 4 characters")
	private String name;

	@NotEmpty(message = "Username  is mandatory")
	@Size(min = 4, max=10, message = "Username should have between 4 to 10 characters")
	private String username;

	@NotEmpty(message = "Email is mandatory")
	@Email(message = "Please provide valid email address")
	private String email;

	@NotNull(message = "Address is mandatory")
	@Valid
	private Address address;

	@NotEmpty(message = "Phone is mandatory")
	@Pattern(message = "Please provide valid phone number in format 000-000-0000", 
					regexp = "\\d{3}-\\d{3}-\\d{4}")
	private String phone;

	@NotEmpty(message = "Website is mandatory")
	@Pattern(message = "Please provide valid website", 
					regexp = "^(http:\\/\\/www\\.|https:\\/\\/www\\.|http:\\/\\/|https:\\/\\/)?[a-z0-9]+([\\-\\.]{1}[a-z0-9]+)*\\.[a-z]{2,5}(:[0-9]{1,5})?(\\/.*)?$")
	private String website;

	@NotNull(message = "Company is mandatory")
	@Valid
	private Company company;

	public UserRequest() {

	}

	public UserRequest(String requestId, String userId, String clientId, String name, String username, String email, Address address, String phone, String website,
			Company company) {
		super(requestId, userId, clientId);
		this.name = name;
		this.username = username;
		this.email = email;
		this.address = address;
		this.phone = phone;
		this.website = website;
		this.company = company;
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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "UserRequest [name=" + name + ", username=" + username + ", email=" + email + ", address=" + address
				+ ", phone=" + phone + ", website=" + website + ", company=" + company + "]";
	}

}
