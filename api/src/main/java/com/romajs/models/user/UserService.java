package com.romajs.models.user;

import io.yawp.repository.IdRef;
import io.yawp.repository.query.QueryBuilder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.romajs.components.History;
import com.romajs.components.Service;
import com.romajs.models.balancechange.BalanceChange;
import com.romajs.models.purchase.Purchase;
import com.romajs.models.user.extract.BalanceChangeExtract;
import com.romajs.models.user.extract.PurchaseUserExtract;
import com.romajs.models.user.extract.UserExtract;

public class UserService extends Service {

	public History<Purchase> purchaseHistory(IdRef<User> userId) {
		QueryBuilder<Purchase> query = yawp.query(Purchase.class).where("userId", "=", userId);
		return History.from(query.executeQueryList());
	}

	public History<BalanceChange> balanceHistory(IdRef<User> userId) {
		QueryBuilder<BalanceChange> query = yawp.query(BalanceChange.class).where("userId", "=", userId);
		return History.from(query.executeQueryList());
	}

	public History<UserExtract> extractHistory(IdRef<User> userId) {
		List<UserExtract> extractHistory = new ArrayList<UserExtract>();
		for (BalanceChange bc : balanceHistory(userId)) {
			BalanceChangeExtract e = new BalanceChangeExtract(bc.getDate(), bc.getIncreasedValue());
			extractHistory.add(e);
		}
		for (Purchase p : purchaseHistory(userId)) {
			PurchaseUserExtract e = new PurchaseUserExtract(p.getDate(), p.getTotalAmount());
			extractHistory.add(e);
		}
		Collections.sort(extractHistory, new Comparator<UserExtract>() {

			@Override
			public int compare(UserExtract e1, UserExtract e2) {
				return e1.getDate().compareTo(e2.getDate());
			}
		});
		return History.from(extractHistory);
	}
}
