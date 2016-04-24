package com.romajs.models.product;

import io.yawp.repository.IdRef;
import io.yawp.repository.query.QueryBuilder;

import com.romajs.components.History;
import com.romajs.components.Service;
import com.romajs.models.purchase.Purchase;


public class ProductService extends Service {

	public Product updateQuantity(IdRef<Product> id, long quantity) {
		Product product = id.fetch();
		product.setQuantity(product.getQuantity() + quantity);
		return yawp.save(product);
	}

	public History<Purchase> purchaseHistory(IdRef<Product> productId) {
		QueryBuilder<Purchase> query = yawp.query(Purchase.class).where("productId", "=", productId);
		return History.from(query.executeQueryList());
	}
}
