package com.romajs.models.user;

import io.yawp.repository.IdRef;
import io.yawp.repository.query.QueryBuilder;

import com.romajs.components.History;
import com.romajs.components.Service;
import com.romajs.models.balancechange.BalanceChange;
import com.romajs.models.purchase.Purchase;

public class UserService extends Service {

	public History<Purchase> purchaseHistory(IdRef<User> userId) {
		QueryBuilder<Purchase> query = yawp.query(Purchase.class).where("userId", "=", userId);
		return History.from(query.executeQueryList());
	}

	public History<BalanceChange> balanceHistory(IdRef<User> userId) {
		QueryBuilder<BalanceChange> query = yawp.query(BalanceChange.class).where("userId", "=", userId);
		return History.from(query.executeQueryList());
	}

}
