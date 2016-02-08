package com.romajs.models.user;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.romajs.utils.EndpointTestCase;

public class UserTest extends EndpointTestCase {

    @Test
    public void testCreate() {
        // TODO Auto-generated method stub
        String json=post("/users", "{}");
        User user=from(json, User.class);

        assertNotNull(user);
    }

}
