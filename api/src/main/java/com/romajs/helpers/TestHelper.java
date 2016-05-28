package com.romajs.helpers;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.math.BigDecimal;

import com.romajs.models.user.UserPassword;

public class TestHelper {

	static final TestHelperDefaults defaults = new TestHelperDefaults();

	public static BigDecimal bigDecimal(double value) {
		return new BigDecimal(value);
	}

	public static ClassLoader classLoader() {
		return Thread.currentThread().getContextClassLoader();
	}

	public static InputStream resourceStream(String resourceName) {
		return classLoader().getResourceAsStream(resourceName);
	}

	public static InputStreamReader resourceReader(String resourceName) {
		InputStream inputStream = resourceStream(resourceName);
		return new InputStreamReader(inputStream);
	}

	public static String resourceContent(String resourceName) {
		StringBuilder content = new StringBuilder();
		try (Reader reader = resourceReader(resourceName)) {
			int c = 0;
			while ((c = reader.read()) != -1) {
				content.append((char) c);
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return content.toString();
	}

	public static UserPassword userPassword(String password) {
		return new UserPassword(password);
	}

}