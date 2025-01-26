package com.api.specification;

import com.api.reader.ConfigReader;

public class BaseURLs {

	protected static final String BASE_URL = ConfigReader.initializeProperty().getBaseUrl();
}
