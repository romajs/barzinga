package com.romajs.models.user;

import io.yawp.repository.IdRef;
import io.yawp.repository.transformers.Transformer;

import com.romajs.components.History;
import com.romajs.components.Service;
import com.romajs.models.user.extract.UserExtract;

public class UserTransformer extends Transformer<User> {

	UserService service = Service.factory(UserService.class, yawp);

	public History<UserExtract> extractHistory(IdRef<User> userId) {
		return service.extractHistory(userId);
	}
}
