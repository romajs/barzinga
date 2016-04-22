package com.romajs.models.balancechange;

import io.yawp.repository.IdRef;
import io.yawp.repository.annotations.Endpoint;
import io.yawp.repository.annotations.Id;

import java.math.BigDecimal;
import java.util.Date;

import com.romajs.models.user.User;

@Endpoint(path = "/balance-changes")
public class BalanceChange {

	@Id
	private IdRef<BalanceChange> id;

	private IdRef<User> userId;

	private BigDecimal previousValue;

	private BigDecimal increasedValue;

	private Date date;

	public IdRef<BalanceChange> getId() {
		return id;
	}

	public void setId(IdRef<BalanceChange> id) {
		this.id = id;
	}

	public IdRef<User> getUserId() {
		return userId;
	}

	public void setUserId(IdRef<User> userId) {
		this.userId = userId;
	}

	public BigDecimal getPreviousValue() {
		return previousValue;
	}

	public void setPreviousValue(BigDecimal previousValue) {
		this.previousValue = previousValue;
	}

	public BigDecimal getIncreasedValue() {
		return increasedValue;
	}

	public void setIncreasedValue(BigDecimal increasedValue) {
		this.increasedValue = increasedValue;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
