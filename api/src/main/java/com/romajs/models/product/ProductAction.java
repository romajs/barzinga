package com.romajs.models.product;

import io.yawp.repository.IdRef;
import io.yawp.repository.actions.Action;

import com.romajs.components.History;
import com.romajs.components.Service;
import com.romajs.models.purchase.Purchase;

public class ProductAction extends Action<Product> {

	ProductService service = Service.factory(ProductService.class, yawp);

	public Product updateQuantity(IdRef<Product> id, long quantity) {
		return service.updateQuantity(id, quantity);
	}

	public History<Purchase> purchaseHistory(IdRef<Product> productId) {
		return service.purchaseHistory(productId);
	}
}
