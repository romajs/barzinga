package com.romajs.models.attachment;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.romajs.utils.EndpointTestCase;

public class AttachmentTest extends EndpointTestCase {

    @Test
    public void testCreate() {
        // TODO Auto-generated method stub
        String json=post("/attachments", "{}");
        Attachment attachment=from(json, Attachment.class);

        assertNotNull(attachment);
    }

}
