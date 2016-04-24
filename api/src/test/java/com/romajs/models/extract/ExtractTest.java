package com.romajs.models.extract;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.romajs.utils.EndpointTestCase;

public class ExtractTest extends EndpointTestCase {

    @Test
    public void testCreate() {
        // TODO Auto-generated method stub
        String json=post("/extracts", "{}");
        Extract extract=from(json, Extract.class);

        assertNotNull(extract);
    }

}
