package com.romajs.models.user;

import io.yawp.repository.IdRef;
import io.yawp.repository.annotations.Id;

public class UserPassword {

	@Id
	private IdRef<UserPassword> id;

	private String password;

	public IdRef<UserPassword> getId() {
		return id;
	}

	public void setId(IdRef<UserPassword> id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserPassword() {
	}

	public UserPassword(String password) {
		this.password = password;
	}

}
