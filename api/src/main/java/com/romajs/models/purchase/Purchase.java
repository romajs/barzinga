package com.romajs.models.purchase;

import io.yawp.repository.IdRef;
import io.yawp.repository.annotations.Endpoint;
import io.yawp.repository.annotations.Id;

import java.util.Date;

import com.romajs.models.product.Product;
import com.romajs.models.user.User;

@Endpoint(path = "/purchases")
public class Purchase {

	@Id
	private IdRef<Purchase> id;

	private IdRef<Product> productId;

	private IdRef<User> usedId;

	private Date date;

	public IdRef<Purchase> getId() {
		return id;
	}

	public void setId(IdRef<Purchase> id) {
		this.id = id;
	}

	public IdRef<Product> getProductId() {
		return productId;
	}

	public void setProductId(IdRef<Product> productId) {
		this.productId = productId;
	}

	public IdRef<User> getUsedId() {
		return usedId;
	}

	public void setUsedId(IdRef<User> usedId) {
		this.usedId = usedId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
