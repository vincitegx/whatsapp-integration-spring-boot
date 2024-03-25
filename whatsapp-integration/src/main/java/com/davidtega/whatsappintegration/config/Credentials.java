package com.davidtega.whatsappintegration.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "credentials", ignoreUnknownFields = false)
public class Credentials {
    private String whatsappAccessToken;
    private String whatsappPhoneNumber;
    private String whatsappPhoneNumberId;
    private String whatsappBusinessAccountId;
    private String whatsappBaseUrl;
}
