package com.testingframework.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

import com.testingframework.constants.FrameworkConstants;
import com.testingframework.enums.ConfigProperties;
import com.testingframework.exceptions.PropertyFileUsageException;

public final class ConfigReader {

	/*
	 * 1. ConfigReader class to read the config.properties file from config folder.
	 * 2. Private constructor declared so that no other class can create new
	 * objects/Instances of this class. 3. EAGER INITIALIZATION
	 */
	private ConfigReader() {

	}

	private static Properties properties = new Properties();
	private static final Map<String, String> CONFIGMAP = new HashMap<>();

	static {

		try (FileInputStream fis = new FileInputStream(FrameworkConstants.getConfigFilePath())) {

			properties.load(fis);

			for (Map.Entry<Object, Object> entry : properties.entrySet()) {
				CONFIGMAP.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()).trim());
			}

		} catch (FileNotFoundException ex) {

			ex.printStackTrace();
			System.exit(0);
		} catch (IOException e) {

			e.printStackTrace();
			System.exit(0);
		}
	}

	public static String get(ConfigProperties key) {

		if (Objects.isNull(key) || Objects.isNull(CONFIGMAP.get(key.name().toLowerCase()))) {
			throw new PropertyFileUsageException("Property name " + key + " is not found. Please check config file.");
		}
		return CONFIGMAP.get(key.name().toLowerCase());
	}

	/*
	 * public static String getValue(String key) throws Exception {
	 * 
	 * if (Objects.isNull(properties.getProperty(key)) || Objects.isNull(key)) {
	 * throw new Exception("Property name " + key +
	 * " is not found. Please check config file."); } return
	 * properties.getProperty(key); }
	 */
}
