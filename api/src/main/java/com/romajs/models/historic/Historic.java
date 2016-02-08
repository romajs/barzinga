package com.romajs.models.historic;

import io.yawp.repository.IdRef;
import io.yawp.repository.annotations.Endpoint;
import io.yawp.repository.annotations.Id;

@Endpoint(path = "/historics")
public class Historic {

    @Id
    IdRef<Historic>id;

}
