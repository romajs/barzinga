package com.romajs.models.purchase;

import io.yawp.repository.IdRef;
import io.yawp.repository.annotations.Endpoint;
import io.yawp.repository.annotations.Id;

import java.math.BigDecimal;
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

	private BigDecimal totalAmount;

	private BigDecimal amount;;

	private Long quantity;

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

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
