package com.davidtega.whatsappintegration.payload;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class MessageRequestDiffblueTest {
    /**
     * Method under test: {@link MessageRequest#toString()}
     */
    @Test
    void testToString() {
        // Arrange, Act and Assert
        assertEquals(
                "MessageRequest{messaging_product='Messaging product', to='alice.liddell@example.org', type='Type',"
                        + " template=WhatsappTemplate[name=Name, language=Language[code=Code]]}",
                (new MessageRequest("Messaging product", "alice.liddell@example.org", "Type",
                        new MessageRequest.WhatsappTemplate("Name", new MessageRequest.WhatsappTemplate.Language("Code"))))
                        .toString());
    }
}
