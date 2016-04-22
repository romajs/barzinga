package com.romajs.models.user;

import io.yawp.repository.IdRef;
import io.yawp.repository.actions.Action;

import com.romajs.components.History;
import com.romajs.components.Service;
import com.romajs.models.purchase.Purchase;

public class UserAction extends Action<User> {
	
	UserService service = Service.factory(UserService.class, yawp);

	public History<Purchase> purchaseHistory(IdRef<User> userId) {
		return service.purchaseHistory(userId);
	}

}
