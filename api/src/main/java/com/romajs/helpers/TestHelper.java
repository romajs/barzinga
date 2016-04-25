package com.romajs.helpers;

import java.math.BigDecimal;

import com.romajs.models.user.UserPassword;

public class TestHelper {

	static final TestHelperDefaults defaults = new TestHelperDefaults();

	public static UserPassword userPassword(String password) {
		return new UserPassword(password);
	}

	public static BigDecimal bigDecimal(double value) {
		return new BigDecimal(value);
	}

}