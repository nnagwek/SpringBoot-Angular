package com.springAngular.rest.webservices.springAngularrestwebservices.jwt.resource;

import java.io.Serializable;

public class JwtTokenRequest implements Serializable {

	private static final long serialVersionUID = -5616176897013108345L;

	private String username;
	private String password;

//	{
//		"token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJpbjI4bWludXRlcyIsImV4cCI6MTU5ODgwNDU1OCwiaWF0IjoxNTk4MTk5NzU4fQ.Q3-SLaUlToLd-9Ig0saHp5Htls-onLoP5GHqW2sbTEhil2U96teZPawJBvjrGcSGcz6S6f78vtwGjtNqAUAfKg"
//	}

	public JwtTokenRequest() {
		super();
	}

	public JwtTokenRequest(String username, String password) {
		this.setUsername(username);
		this.setPassword(password);
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}