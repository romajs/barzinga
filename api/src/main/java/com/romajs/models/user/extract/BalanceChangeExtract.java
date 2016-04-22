package com.romajs.models.user.extract;

import java.math.BigDecimal;
import java.util.Date;

public class BalanceChangeExtract extends UserExtract {

	public BalanceChangeExtract(Date date, BigDecimal amount) {
		super(Type.BALANCE);
		this.description = Type.BALANCE.toString();
		this.date = date;
		this.amount = amount;
	}

}