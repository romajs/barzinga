package com.romajs.models.product;

import io.yawp.repository.IdRef;
import io.yawp.repository.actions.Action;

public class ProductAction extends Action<Product> {

	public long updateAmount(IdRef<Product> id, long amount) {
		Product product = id.fetch();
		product.setAmount(product.getAmount() + amount);
		yawp.save(product);
		return product.getAmount().longValue();
	}
}
