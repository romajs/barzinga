package com.romajs.models.purchase;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.romajs.utils.EndpointTestCase;

public class PurchaseTest extends EndpointTestCase {

    @Test
    public void testCreate() {
        // TODO Auto-generated method stub
        String json=post("/purchases", "{}");
        Purchase purchase=from(json, Purchase.class);

        assertNotNull(purchase);
    }

}
