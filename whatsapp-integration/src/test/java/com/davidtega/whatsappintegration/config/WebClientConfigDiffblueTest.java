package com.davidtega.whatsappintegration.config;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {WebClientConfig.class})
@ExtendWith(SpringExtension.class)
class WebClientConfigDiffblueTest {
    @Autowired
    private WebClientConfig webClientConfig;

    /**
     * Method under test: {@link WebClientConfig#webClientBuilder()}
     */
    @Test
    void testWebClientBuilder() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   Add getters for the following fields or make them package-private:
        //     DefaultWebClientBuilder.baseUrl
        //     DefaultWebClientBuilder.connector
        //     DefaultWebClientBuilder.defaultCookies
        //     DefaultWebClientBuilder.defaultHeaders
        //     DefaultWebClientBuilder.defaultRequest
        //     DefaultWebClientBuilder.defaultUriVariables
        //     DefaultWebClientBuilder.exchangeFunction
        //     DefaultWebClientBuilder.filters
        //     DefaultWebClientBuilder.observationConvention
        //     DefaultWebClientBuilder.observationRegistry
        //     DefaultWebClientBuilder.statusHandlers
        //     DefaultWebClientBuilder.strategies
        //     DefaultWebClientBuilder.strategiesConfigurers
        //     DefaultWebClientBuilder.uriBuilderFactory

        // Arrange and Act
        webClientConfig.webClientBuilder();
    }
}
