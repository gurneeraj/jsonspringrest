package com.xyz.jsonproject.model;

import javax.validation.constraints.NotNull;

/**
 *  All fields are validated using hibernate validation api
 *  
 * @author gurneerajsinghdahele
 *
 */
public class Company {
	@NotNull(message = "Company name is mandatory")
	private String name;
	
	@NotNull(message = "Company catch phrase is mandatory")
	private String catchPhrase;
	
	@NotNull(message = "Company business style is mandatory")
	private String bs;
	
	public Company(){
		
	}

	public Company(String name, String catchPhrase, String bs) {
		super();
		this.name = name;
		this.catchPhrase = catchPhrase;
		this.bs = bs;
	}

	public String getName() {
		return name;
	}

	public String getCatchPhrase() {
		return catchPhrase;
	}

	public String getBs() {
		return bs;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCatchPhrase(String catchPhrase) {
		this.catchPhrase = catchPhrase;
	}

	public void setBs(String bs) {
		this.bs = bs;
	}

	@Override
	public String toString() {
		return "Company [name=" + name + ", catchPhrase=" + catchPhrase + ", bs=" + bs + "]";
	}
}
