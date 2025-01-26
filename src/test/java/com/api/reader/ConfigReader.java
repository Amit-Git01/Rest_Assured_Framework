package com.api.reader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	private static Properties properties;
	private static FileInputStream fileInputStream;
	private static final String configPath = "./src/test/resources/config.properties";
	
	private ConfigReader() {};
	
	public static ConfigReader initializeProperty() {
		
		try {
			fileInputStream = new FileInputStream(new File(configPath));
			properties = new Properties();
			if (fileInputStream == null) {
                throw new RuntimeException("Unable to find config.properties");
            }
			properties.load(fileInputStream);
			fileInputStream.close();
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return new ConfigReader();
		
	}
	
	public String getBaseUrl() {
		return properties.getProperty("baseurl");
	}
	
}
