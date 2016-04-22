package com.romajs.models.user.extract;

import java.math.BigDecimal;
import java.util.Date;

public class PurchaseUserExtract extends UserExtract {

	public PurchaseUserExtract(Date date, BigDecimal amount) {
		super(Type.PURCHASE);
		this.description = Type.BALANCE.toString();
		this.date = date;
		this.amount = amount;
	}

}