package com.romajs.models.product;

import io.yawp.repository.IdRef;
import io.yawp.repository.annotations.Endpoint;
import io.yawp.repository.annotations.Id;

import java.math.BigDecimal;
import java.util.List;

import com.romajs.models.attachment.Attachment;

@Endpoint(path = "/products")
public class Product {

	@Id
	private IdRef<Product> id;

	private String name;

	private String description;

	private BigDecimal amount;

	private Long quantity;

	private List<IdRef<Attachment>> attachments;

	public IdRef<Product> getId() {
		return id;
	}

	public void setId(IdRef<Product> id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public List<IdRef<Attachment>> getAttachments() {
		return attachments;
	}

	public void setAttachments(List<IdRef<Attachment>> attachments) {
		this.attachments = attachments;
	}

}
