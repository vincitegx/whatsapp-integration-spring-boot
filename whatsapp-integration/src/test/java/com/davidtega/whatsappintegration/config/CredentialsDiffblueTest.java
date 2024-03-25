package com.davidtega.whatsappintegration.config;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class CredentialsDiffblueTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Credentials#setWhatsappAccessToken(String)}
     *   <li>{@link Credentials#setWhatsappBaseUrl(String)}
     *   <li>{@link Credentials#setWhatsappBusinessAccountId(String)}
     *   <li>{@link Credentials#setWhatsappPhoneNumber(String)}
     *   <li>{@link Credentials#setWhatsappPhoneNumberId(String)}
     *   <li>{@link Credentials#getWhatsappAccessToken()}
     *   <li>{@link Credentials#getWhatsappBaseUrl()}
     *   <li>{@link Credentials#getWhatsappBusinessAccountId()}
     *   <li>{@link Credentials#getWhatsappPhoneNumber()}
     *   <li>{@link Credentials#getWhatsappPhoneNumberId()}
     * </ul>
     */
    @Test
    void testGettersAndSetters() {
        // Arrange
        Credentials credentials = new Credentials();

        // Act
        credentials.setWhatsappAccessToken("ABC123");
        credentials.setWhatsappBaseUrl("https://example.org/example");
        credentials.setWhatsappBusinessAccountId("42");
        credentials.setWhatsappPhoneNumber("6625550144");
        credentials.setWhatsappPhoneNumberId("6625550144");
        String actualWhatsappAccessToken = credentials.getWhatsappAccessToken();
        String actualWhatsappBaseUrl = credentials.getWhatsappBaseUrl();
        String actualWhatsappBusinessAccountId = credentials.getWhatsappBusinessAccountId();
        String actualWhatsappPhoneNumber = credentials.getWhatsappPhoneNumber();

        // Assert that nothing has changed
        assertEquals("42", actualWhatsappBusinessAccountId);
        assertEquals("6625550144", actualWhatsappPhoneNumber);
        assertEquals("6625550144", credentials.getWhatsappPhoneNumberId());
        assertEquals("ABC123", actualWhatsappAccessToken);
        assertEquals("https://example.org/example", actualWhatsappBaseUrl);
    }
}
