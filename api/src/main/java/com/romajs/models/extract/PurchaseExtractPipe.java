package com.romajs.models.extract;

import io.yawp.repository.pipes.Pipe;

import com.romajs.models.extract.Extract.Type;
import com.romajs.models.purchase.Purchase;

public class PurchaseExtractPipe extends Pipe<Purchase, Extract> {

	static final Type type = Extract.Type.PURCHASE;

	@Override
	public void configureSinks(Purchase purchase) {
		//		addSinkId(id(Extract.class, purchase.getId().asLong()));
	}

	@Override
	public void flux(Purchase purchase, Extract extract) {
		extract.setAmount(purchase.getAmount());
		extract.setDate(purchase.getDate());
		extract.setDescription(purchase.getProductId().fetch().getName());
		extract.setType(type);
	}

	@Override
	public void reflux(Purchase purchase, Extract extract) {
		// ???
	}

}
