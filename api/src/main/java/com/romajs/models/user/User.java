package com.romajs.models.user;

import io.yawp.repository.IdRef;
import io.yawp.repository.annotations.Endpoint;
import io.yawp.repository.annotations.Id;

@Endpoint(path = "/users")
public class User {

	@Id
	private IdRef<User> id;

	private String email;

	private String nickname;

	private String username;

	private IdRef<UserPassword> userPassword;

	public User() {
	}

	public User(String email, String nickname, String username, UserPassword userPassword) {
		this.email = email;
		this.nickname = nickname;
		this.username = username;
		this.userPassword = userPassword.getId();
	}

	public String getEmail() {
		return email;
	}

	public IdRef<User> getId() {
		return id;
	}

	public String getNickname() {
		return nickname;
	}

	public String getUsername() {
		return username;
	}

	public IdRef<UserPassword> getUserPassword() {
		return userPassword;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setId(IdRef<User> id) {
		this.id = id;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setUserPassword(IdRef<UserPassword> userPassword) {
		this.userPassword = userPassword;
	}

}
