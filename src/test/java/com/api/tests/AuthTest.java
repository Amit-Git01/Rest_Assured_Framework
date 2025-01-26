package com.api.tests;

import java.util.HashMap;
import java.util.Map;

import com.aventstack.chaintest.plugins.ChainTestListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.api.constants.StatusCode;
import com.api.model.request.Register_Patch_UserRequest;
import com.api.service.Authentication;
import com.api.utils.Asserts;
import com.api.utils.GetData;
import com.api.utils.TokenManager;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class AuthTest {

	private static final Logger LOGGER = LogManager.getLogger(AuthTest.class);

	Authentication auth;
	Response res;
	String token;
	
	Register_Patch_UserRequest request;

	@BeforeSuite
	public void init() {
		request = new Register_Patch_UserRequest.Builder()
				.username(GetData.uname)
				.firstName(GetData.fname)
				.lastName(GetData.lname)
				.email(GetData.email)
				.password(GetData.password)
				.phone(GetData.phone)
				.userStatus(1)
				.build();
		
		auth = new Authentication();
		Response response = auth.registerRequest(request);
//		System.out.println(response.getStatusLine());
		ChainTestListener.log("User is created!! " + response.getStatusCode());
		

	}

	@Test(description = "Login with valid credentials")
	public void userlogin() {

		Map<String, String> jsonAsMap = new HashMap<String, String>();
		jsonAsMap.put("username", GetData.uname);
		jsonAsMap.put("password", GetData.password);
		auth = new Authentication();
		res = auth.loginRequest(jsonAsMap);

		JsonPath jsonpath = res.jsonPath();
		token = jsonpath.getString("token");
		TokenManager.setBearerToken(token);

//		System.out.println(res.getBody().asPrettyString());
		int statusCode = res.getStatusCode();
//		System.out.println(res.getStatusCode());

		LOGGER.info("Status Code : {}", statusCode);
		ChainTestListener.log("Status Code : "+ statusCode);

//		System.out.println(token);

		Asserts.equals(statusCode, StatusCode.OK.getCode());

	}

}
