package com.romajs.models.product;

import com.romajs.components.History;
import com.romajs.models.purchase.Purchase;

import io.yawp.repository.IdRef;
import io.yawp.repository.actions.Action;
import io.yawp.repository.query.QueryBuilder;

public class ProductAction extends Action<Product> {

	public Product updateAmount(IdRef<Product> id, long amount) {
		Product product = id.fetch();
		product.setAmount(product.getAmount() + amount);
		return yawp.save(product);
	}

	public History<Purchase> purchaseHistory(IdRef<Product> productId) {
		QueryBuilder<Purchase> query = yawp.query(Purchase.class).where("productId", "=", productId);
		return History.from(query.executeQueryList());
	}
}
