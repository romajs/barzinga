package com.romajs.models.product;

import io.yawp.commons.http.annotation.GET;
import io.yawp.commons.http.annotation.POST;
import io.yawp.commons.http.annotation.PUT;
import io.yawp.repository.IdRef;
import io.yawp.repository.actions.Action;

import java.util.List;

import com.romajs.components.History;
import com.romajs.components.Service;
import com.romajs.models.purchase.Purchase;

public class ProductAction extends Action<Product> {

	ProductService service = Service.factory(ProductService.class, yawp);
	
	@POST("postWithAttachments")
	public Product postWithAttachments(List<ProductAttachment> attachments) {
//		product = yawp.saveWithHooks(product);
//		for(Attachment attachment: attachments) {
//			attachment.setProductId(product.getId());
//			yawp.save(attachment);
//		}
		return null;
	}

	@PUT("updateQuantity")
	public Product updateQuantity(IdRef<Product> id, long quantity) {
		return service.updateQuantity(id, quantity);
	}

	@GET("purchaseHistory")
	public History<Purchase> purchaseHistory(IdRef<Product> productId) {
		return service.purchaseHistory(productId);
	}
}
