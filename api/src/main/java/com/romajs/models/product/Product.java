package com.romajs.models.product;

import java.math.BigDecimal;
import java.util.List;

import com.romajs.models.attachment.Attachment;

import io.yawp.repository.IdRef;
import io.yawp.repository.annotations.Endpoint;
import io.yawp.repository.annotations.Id;

@Endpoint(path = "/products")
public class Product {

	@Id
	private IdRef<Product> id;

	private String name;

	private String description;

	private BigDecimal value;

	private Long amount;

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

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public List<IdRef<Attachment>> getAttachments() {
		return attachments;
	}

	public void setAttachments(List<IdRef<Attachment>> attachments) {
		this.attachments = attachments;
	}

}
