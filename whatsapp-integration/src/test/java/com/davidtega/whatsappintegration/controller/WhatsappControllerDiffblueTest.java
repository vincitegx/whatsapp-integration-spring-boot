package com.davidtega.whatsappintegration.controller;

import static org.mockito.Mockito.when;

import com.davidtega.whatsappintegration.payload.MessageRequest;
import com.davidtega.whatsappintegration.payload.MessageResponse;
import com.davidtega.whatsappintegration.service.WhatsappService;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {WhatsappController.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class WhatsappControllerDiffblueTest {
    @Autowired
    private WhatsappController whatsappController;

    @MockBean
    private WhatsappService whatsappService;

    /**
     * Method under test:
     * {@link WhatsappController#sendWhatsappMessage(MessageRequest)}
     */
    @Test
    void testSendWhatsappMessage() throws Exception {
        // Arrange
        ArrayList<MessageResponse.Contacts> contacts = new ArrayList<>();
        when(whatsappService.sendWhatsappMessage(Mockito.<MessageRequest>any()))
                .thenReturn(new MessageResponse("Messaging product", contacts, new ArrayList<>()));
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/api/v1/whatsapp/message")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(
                objectMapper.writeValueAsString(new MessageRequest("Messaging product", "alice.liddell@example.org", "Type",
                        new MessageRequest.WhatsappTemplate("Name", new MessageRequest.WhatsappTemplate.Language("Code")))));

        // Act and Assert
        MockMvcBuilders.standaloneSetup(whatsappController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"messaging_product\":\"Messaging product\",\"contacts\":[],\"messages\":[]}"));
    }
}
