package com.api.specification;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;

public class UserManagementSpec extends BaseURLs {

    private static final String BASE_PATH = "/user";
    private static final String BASE_PATH_ID = "/user/{id}";

    public static RequestSpecification getRequestSpec() {
        return new RequestSpecBuilder()
                .setBaseUri(BASE_URL)
                .setBasePath(BASE_PATH)
                //.log(LogDetail.ALL)
                .build();
    }

    public static RequestSpecification patchRequestSpec() {
        return new RequestSpecBuilder()
                .setBaseUri(BASE_URL)
                .setBasePath(BASE_PATH_ID)
                .log(LogDetail.ALL)
                .build();
    }


}
