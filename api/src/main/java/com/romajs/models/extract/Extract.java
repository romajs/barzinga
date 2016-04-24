package com.romajs.models.extract;

import io.yawp.repository.IdRef;
import io.yawp.repository.annotations.Endpoint;
import io.yawp.repository.annotations.Id;

import java.math.BigDecimal;
import java.util.Date;

import com.romajs.models.user.User;

@Endpoint(path = "/extracts")
public class Extract {

	public enum Type {
		BALANCE, PURCHASE
	}

	@Id
	private IdRef<Extract> id;

	private IdRef<User> userId;

	private Type type;

	private Date date;

	private String description;

	private BigDecimal amount;

	public Extract(Type type) {
		this.type = type;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public Date getDate() {
		return date;
	}

	public String getDescription() {
		return description;
	}

	public IdRef<Extract> getId() {
		return id;
	}

	public Type getType() {
		return type;
	}

	public IdRef<User> getUserId() {
		return userId;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setId(IdRef<Extract> id) {
		this.id = id;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public void setUserId(IdRef<User> userId) {
		this.userId = userId;
	}
}
