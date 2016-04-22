package com.romajs.models.user.extract;

import java.math.BigDecimal;
import java.util.Date;

public class UserExtract {

	enum Type {
		BALANCE, PURCHASE
	}

	protected Type type;
	protected Date date;
	protected String description;
	protected BigDecimal amount;

	public UserExtract(Type type) {
		this.type = type;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

}
