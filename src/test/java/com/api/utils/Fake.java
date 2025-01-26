package com.api.utils;

import com.github.javafaker.Faker;

public class Fake {

	private static Fake fake;
	private static Faker faker;

	private Fake() {
		faker = new Faker();
	}

	public static Fake getInstance() {
		if (fake == null) {
			fake = new Fake();
		}
		return fake;
	}
	
	public String getUsername() {
		return faker.name().username();
	}

	public String getFirstName() {
		return faker.name().firstName();
	}

	public String getLastName() {
		return faker.name().lastName();
	}

	public String getEmail() {
		return faker.internet().emailAddress();
	}

	public String getPassword() {
		return faker.internet().password().substring(0, 6);
	}

	public String getPhone() {
		return faker.phoneNumber().cellPhone().replaceAll("[^\\d]", "");
	}
}
