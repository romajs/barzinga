package com.romajs.models.user;

import io.yawp.repository.IdRef;
import io.yawp.repository.actions.Action;
import io.yawp.repository.query.QueryBuilder;

import com.romajs.components.History;
import com.romajs.models.purchase.Purchase;

public class UserAction extends Action<User> {

	public History<Purchase> purchaseHistory(IdRef<User> userId) {
		QueryBuilder<Purchase> query = yawp.query(Purchase.class).where("userId", "=", userId);
		return History.from(query.executeQueryList());
	}

}
