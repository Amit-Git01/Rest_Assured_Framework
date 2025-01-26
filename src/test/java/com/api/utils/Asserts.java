package com.api.utils;

import org.testng.Assert;

public class Asserts {
	
	public static void equals(String actual, String expected) {
		Assert.assertEquals(actual, expected, actual+" is not equal to " + expected + "!!");
	}
	
	public static void equals(int actual, int expected) {
		Assert.assertEquals(actual, expected, actual+" is not equal to " + expected + "!!");
	}
	
	
	public static void isTrue(boolean actual) {
		Assert.assertTrue(actual);
	}

}
