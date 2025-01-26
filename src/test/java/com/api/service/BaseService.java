package com.api.service;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseService {

	protected Response postRequest(RequestSpecification requestSpecification) {
		return RestAssured.given().spec(requestSpecification).when().post();
	}
	
	protected Response getRequest(RequestSpecification requestSpecification) {
		return RestAssured.given().spec(requestSpecification).when().get();
	}
	
	protected Response patchRequest(RequestSpecification requestSpecification) {
		return RestAssured.given().spec(requestSpecification).when().patch();
	}

	protected Response deleteRequest(RequestSpecification requestSpecification) {
		return RestAssured.given().spec(requestSpecification).when().delete();
	}

}
