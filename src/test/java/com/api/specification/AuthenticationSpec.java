package com.api.specification;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;

public class AuthenticationSpec extends BaseURLs {

    private static final String BASE_PATH = "/login";
    private static final String BASE_PATH1 = "/register";

    public static RequestSpecification loginRequestSpec() {
        return new RequestSpecBuilder()
                .setBaseUri(BASE_URL)
                .setBasePath(BASE_PATH)
               // .log(LogDetail.ALL)
                .build();
    }

    public static RequestSpecification registerRequestSpec() {
        return new RequestSpecBuilder()
                .setBaseUri(BASE_URL)
                .setBasePath(BASE_PATH1)
               // .log(LogDetail.ALL)
                .build();
    }
}
