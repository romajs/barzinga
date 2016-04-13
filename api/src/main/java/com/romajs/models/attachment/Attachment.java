package com.romajs.models.attachment;

import io.yawp.repository.IdRef;
import io.yawp.repository.annotations.Endpoint;
import io.yawp.repository.annotations.Id;

@Endpoint(path = "/attachments")
public class Attachment {

	@Id
	private IdRef<Attachment> id;

	private String name;

	private String path;

	private AttachmentType type;

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

}
