package com.romajs.models.attachment;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.romajs.models.product.ProductAttachment;
import com.romajs.utils.EndpointTestCase;

public class AttachmentTest extends EndpointTestCase {

    @Test
    public void testCreate() {
        // TODO Auto-generated method stub
        String json=post("/attachments", "{}");
        ProductAttachment attachment=from(json, ProductAttachment.class);

        assertNotNull(attachment);
    }

}
