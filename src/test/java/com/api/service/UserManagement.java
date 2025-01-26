package com.api.service;

import com.api.specification.UserManagementSpec;

import io.restassured.response.Response;

public class UserManagement extends BaseService{

	public Response getUserRequest(String username, String token) {
		return getRequest(UserManagementSpec.getRequestSpec()
				.queryParam("username", username)
				.header("Accept", "application/json")
				.header("Authorization", "Bearer " + token));
	}
	
	public Response patchUserRequest(int id, Object payload, String token) {
		return patchRequest(UserManagementSpec.patchRequestSpec()
				.pathParam("id", id)
				.header("Accept", "application/json")
				.header("Content-Type", "application/json")
				.header("Authorization", "Bearer " + token)
				.body(payload));
	}

	public Response deleteUserRequest(String username, String token) {
		return deleteRequest(UserManagementSpec.getRequestSpec()
				.queryParam("username", username)
				.header("Accept", "*/*")
				.header("Authorization", "Bearer " + token));
	}
	
}
