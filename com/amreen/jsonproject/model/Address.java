package com.amreen.jsonproject.model;

import javax.validation.constraints.NotNull;

/**
 *  All fields are validated using hibernate validation api
 *  
 * @author gurneerajsinghdahele
 *
 */
public class Address {

	@NotNull(message = "Street address is mandatory")
	private String street;
	
	@NotNull(message = "Suite name is mandatory")
	private String suite;
	
	@NotNull(message = "City name is mandatory")
	private String city;
	
	@NotNull(message = "Zipcode is mandatory")
	private String zipcode;
	
	public Address() {
		
	}

	public Address(String street, String suite, String city, String zipcode) {
		super();
		this.street = street;
		this.suite = suite;
		this.city = city;
		this.zipcode = zipcode;
	}

	public String getStreet() {
		return street;
	}

	public String getSuite() {
		return suite;
	}

	public String getCity() {
		return city;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public void setSuite(String suite) {
		this.suite = suite;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	@Override
	public String toString() {
		return "Address [street address=" + street + ", suite=" + suite + ", city=" + city + ", zipcode=" + zipcode
				+ "]";
	}

}
