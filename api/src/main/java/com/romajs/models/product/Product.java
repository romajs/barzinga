package com.romajs.models.product;

import io.yawp.repository.IdRef;
import io.yawp.repository.annotations.Endpoint;
import io.yawp.repository.annotations.Id;
import io.yawp.repository.annotations.Index;
import io.yawp.repository.annotations.Json;

import java.util.List;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Endpoint(path = "/products")
public class Product {

	@Id
	private IdRef<Product> id;

	@Index
	private String name;

	private String description;

	@Index
	private Long quantity;

	private Double value;
	
	@Json
	private List<ProductAttachment> attachments;

	public Product() {
	}

	public Product(String name, String description, Long quantity, Double value) {
		this.name = name;
		this.description = description;
		this.quantity = quantity;
		this.value = value;
	}

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

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
