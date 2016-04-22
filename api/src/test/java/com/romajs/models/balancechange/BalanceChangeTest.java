package com.romajs.models.balancechange;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.romajs.utils.EndpointTestCase;

public class BalanceChangeTest extends EndpointTestCase {

    @Test
    public void testCreate() {
        // TODO Auto-generated method stub
        String json=post("/balance-changes", "{}");
        BalanceChange balanceChange=from(json, BalanceChange.class);

        assertNotNull(balanceChange);
    }

}
