package com.romajs.helpers;

import com.romajs.models.user.UserPassword;

public class TestHelperDefaults {

	public UserPassword userPassword() {
		return new UserPassword("123");
	}
}