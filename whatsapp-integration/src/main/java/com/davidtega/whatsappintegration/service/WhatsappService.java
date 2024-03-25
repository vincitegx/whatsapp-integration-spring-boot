package com.davidtega.whatsappintegration.service;

import com.davidtega.whatsappintegration.config.Credentials;
import com.davidtega.whatsappintegration.payload.MessageRequest;
import com.davidtega.whatsappintegration.payload.MessageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import static io.netty.handler.codec.http.HttpHeaders.Values.APPLICATION_JSON;

@Service
@RequiredArgsConstructor
public class WhatsappService {
    private final WebClient.Builder webClientBuilder;
    private final Credentials credentials;
    private final static String BEARER = "Bearer ";
    public MessageResponse sendWhatsappMessage(MessageRequest messageRequest){
        return webClientBuilder.build()
                .post()
                .uri(credentials.getWhatsappBaseUrl()+credentials.getWhatsappPhoneNumberId()+"/messages")
                .header(HttpHeaders.AUTHORIZATION, BEARER+credentials.getWhatsappAccessToken())
                .header(HttpHeaders.CONTENT_TYPE, APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .bodyValue(messageRequest)
                .retrieve()
                .bodyToMono(MessageResponse.class)
                .block();
    }
}
