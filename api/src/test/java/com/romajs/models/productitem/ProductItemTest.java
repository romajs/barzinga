package com.romajs.models.productitem;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.romajs.utils.EndpointTestCase;

public class ProductItemTest extends EndpointTestCase {

    @Test
    public void testCreate() {
        // TODO Auto-generated method stub
        String json=post("/product-items", "{}");
        ProductItem productItem=from(json, ProductItem.class);

        assertNotNull(productItem);
    }

}
