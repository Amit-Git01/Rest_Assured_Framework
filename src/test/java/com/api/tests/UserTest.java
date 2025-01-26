package com.api.tests;

import com.aventstack.chaintest.plugins.ChainTestListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.api.constants.StatusCode;
import com.api.model.request.Register_Patch_UserRequest;
import com.api.model.response.UserResponse;
import com.api.service.UserManagement;
import com.api.utils.Asserts;
import com.api.utils.Fake;
import com.api.utils.GetData;
import com.api.utils.TokenManager;

import io.restassured.response.Response;

public class UserTest {
	
	private static final Logger LOGGER = LogManager.getLogger(UserTest.class);
	
	public String token;
	
	UserManagement management;
	Response response;
	public int id;

	@Test(description = "Validate get request",priority = 1, enabled = true)
	public void getUserTest() {
		
		System.out.println(TokenManager.getBearerToken());
		token = TokenManager.getBearerToken();
		management = new UserManagement();
		response = management.getUserRequest(GetData.uname, token);
		
		int statusCode = response.getStatusCode();
		
		Asserts.equals(statusCode, StatusCode.OK.getCode());
		
		if(statusCode == StatusCode.OK.getCode()) {
			UserResponse userRes = response.as(UserResponse.class);
			
//			System.out.println(userRes.getMessage());
//			System.out.println(userRes.getResponse().getEmail());
//			System.out.println(userRes.getResponse().getLastName());

			id = userRes.getResponse().getId();
			String uname = userRes.getResponse().getUsername();
			String fname = userRes.getResponse().getFirstName();
			String lname = userRes.getResponse().getLastName();
			String email = userRes.getResponse().getEmail();
			String msg = userRes.getMessage();
			
			LOGGER.info("User Id : {}", id);
			ChainTestListener.log("User Id : "+ id);

			ChainTestListener.log("Username : "+uname);

			
			Asserts.equals(fname, GetData.fname);
			LOGGER.info("User firstname : {}", fname);
			ChainTestListener.log("User firstname : "+ fname);
			
			Asserts.equals(lname, GetData.lname);
			LOGGER.info("User lastname : {}", lname);
			ChainTestListener.log("User lastname : "+ lname);
			
			Asserts.equals(email, GetData.email);
			LOGGER.info("User email : {}", email);
			ChainTestListener.log("User email : "+ email);
			
			Asserts.equals(msg, "Success");
			LOGGER.info("User message : {}", msg);
			ChainTestListener.log("Response message : "+ msg);
			
		}
		else {
			throw new RuntimeException("User not found!!!");
		}		
	}
	
	@Test(description = "Validate patch request",priority = 2, dependsOnMethods = "getUserTest" ,enabled = true)
	public void patchUserTest() {

		String newlname = Fake.getInstance().getLastName();
		String newEmail = Fake.getInstance().getEmail();

		Register_Patch_UserRequest newPayload = new Register_Patch_UserRequest.Builder()
				.lastName(newlname)
				.email(newEmail).build();

		token = TokenManager.getBearerToken();
		management = new UserManagement();
		ChainTestListener.log("Updating user : " + GetData.uname);
		response = management.patchUserRequest(id, newPayload, token);
//		System.out.println("============================");
//		System.out.println(res.getBody().asPrettyString());
//		System.out.println("============================");


		UserResponse userReponse = response.as(UserResponse.class);

		String lastname = userReponse.getResponse().getLastName();
		String email = userReponse.getResponse().getEmail();

		Asserts.equals(lastname, newlname);  // making test fail
		LOGGER.info("User lastname : {}", lastname);
		ChainTestListener.log("User lastname : "+ lastname);

		Asserts.equals(email, newEmail);
		LOGGER.info("User email : {}", email);
		ChainTestListener.log("User email : "+ email);

	}

	@Test(description = "verify user is deleted", priority = 3)
	public void deleteUserTest() {

		ChainTestListener.log("Deleting user : " + GetData.uname);
		token = TokenManager.getBearerToken();
		management = new UserManagement();
		response = management.deleteUserRequest(GetData.uname, token);

		int statusCode = response.getStatusCode();

		Asserts.equals(statusCode, StatusCode.OK.getCode());

		UserResponse userResponse = response.as(UserResponse.class);

		String msg = userResponse.getMessage();

		Asserts.equals(msg, "Success");

	}
}
