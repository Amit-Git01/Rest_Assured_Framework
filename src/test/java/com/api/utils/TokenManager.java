package com.api.utils;

public class TokenManager {
	
	private static String bearerToken;

    public static void setBearerToken(String token) {
        bearerToken = token;
    }

    public static String getBearerToken() {
        return bearerToken;
    }
}
