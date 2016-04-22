package com.romajs.components;

import io.yawp.repository.Feature;
import io.yawp.repository.Repository;

public class Service extends Feature {

	public <T extends Service> T feature(Class<T> clazz, Repository yawp) {
		this.setRepository(yawp);
		return super.feature(clazz);
	}

	public static <T extends Service> T factory(Class<T> clazz, Repository yawp) {
		return new Service().feature(clazz, yawp);
	}
}
