package com.romajs.models.historic;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.romajs.utils.EndpointTestCase;

public class HistoricTest extends EndpointTestCase {

    @Test
    public void testCreate() {
        // TODO Auto-generated method stub
        String json=post("/historics", "{}");
        Historic historic=from(json, Historic.class);

        assertNotNull(historic);
    }

}
