package com.api.service;

import java.util.Map;

import com.api.specification.AuthenticationSpec;

import io.restassured.response.Response;

public class Authentication extends BaseService{

	
	public <K, V> Response loginRequest(Map<K, V> body) {
		return postRequest(AuthenticationSpec.loginRequestSpec()
				.header("Content-Type", "application/json")
		        .header("Accept", "application/json")
		        .body(body));
	}
	
	public Response registerRequest(Object body) {
		return postRequest(AuthenticationSpec.registerRequestSpec()
				.header("Content-Type", "application/json")
				.header("Accept", "application/json")
				.body(body));
	}
}
