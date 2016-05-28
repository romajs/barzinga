package com.romajs.models.attachment;

import io.yawp.repository.IdRef;
import io.yawp.repository.annotations.Endpoint;
import io.yawp.repository.annotations.Id;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.romajs.models.product.Product;

@Endpoint(path = "/attachments")
public class Attachment {

	@Id
	private IdRef<Attachment> id;

	private String name;

	private String path;

	private AttachmentType type;

	private IdRef<Product> productId;

	public IdRef<Attachment> getId() {
		return id;
	}

	public void setId(IdRef<Attachment> id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public AttachmentType getType() {
		return type;
	}

	public void setType(AttachmentType type) {
		this.type = type;
	}

	public IdRef<Product> getProductId() {
		return productId;
	}

	public void setProductId(IdRef<Product> productId) {
		this.productId = productId;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
