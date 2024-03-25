package com.davidtega.whatsappintegration.payload;

import java.util.List;

public record MessageResponse(String messaging_product, List<Contacts> contacts, List<Messages> messages) {

    public record Contacts(String input, String wa_id){}
    public record Messages(String id, String message_status){}
}
