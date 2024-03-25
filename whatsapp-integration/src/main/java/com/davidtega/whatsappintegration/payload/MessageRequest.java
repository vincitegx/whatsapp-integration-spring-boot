package com.davidtega.whatsappintegration.payload;

import org.springframework.lang.NonNull;

public record MessageRequest(@NonNull String messaging_product,@NonNull String to,@NonNull String type,@NonNull WhatsappTemplate template) {
    public record WhatsappTemplate(@NonNull String name, @NonNull Language language){
        public record Language(@NonNull String code){}
    }

    @Override
    public String toString() {
        return "MessageRequest{" +
                "messaging_product='" + messaging_product + '\'' +
                ", to='" + to + '\'' +
                ", type='" + type + '\'' +
                ", template=" + template +
                '}';
    }
}
