package com.romajs.models.balance;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.romajs.utils.EndpointTestCase;

public class BalanceTest extends EndpointTestCase {

    @Test
    public void testCreate() {
        // TODO Auto-generated method stub
        String json=post("/balances", "{}");
        Balance balance=from(json, Balance.class);

        assertNotNull(balance);
    }

}
