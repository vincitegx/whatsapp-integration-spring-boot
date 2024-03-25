package com.davidtega.whatsappintegration.service;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.davidtega.whatsappintegration.config.Credentials;
import com.davidtega.whatsappintegration.payload.MessageRequest;
import com.davidtega.whatsappintegration.payload.MessageResponse;

import java.util.ArrayList;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@ContextConfiguration(classes = {WhatsappService.class, Credentials.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class WhatsappServiceDiffblueTest {
    @MockBean
    private WebClient.Builder builder;

    @Autowired
    private Credentials credentials;

    @Autowired
    private WhatsappService whatsappService;

    /**
     * Method under test:
     * {@link WhatsappService#sendWhatsappMessage(MessageRequest)}
     */
    @Test
    void testSendWhatsappMessage() {
        //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

        // Arrange
        WebClient.ResponseSpec responseSpec = mock(WebClient.ResponseSpec.class);
        ArrayList<MessageResponse.Contacts> contacts = new ArrayList<>();
        MessageResponse messageResponse = new MessageResponse("Messaging product", contacts, new ArrayList<>());

        Mono<MessageResponse> justResult = Mono.just(messageResponse);
        when(responseSpec.bodyToMono(Mockito.<Class<MessageResponse>>any())).thenReturn(justResult);
        WebClient.RequestHeadersSpec<WebClient.RequestBodySpec> requestHeadersSpec = mock(
                WebClient.RequestHeadersSpec.class);
        when(requestHeadersSpec.retrieve()).thenReturn(responseSpec);
        WebClient.RequestBodySpec requestBodySpec = mock(WebClient.RequestBodySpec.class);
        Mockito.<WebClient.RequestHeadersSpec<?>>when(requestBodySpec.bodyValue(Mockito.<Object>any()))
                .thenReturn(requestHeadersSpec);
        WebClient.RequestBodySpec requestBodySpec2 = mock(WebClient.RequestBodySpec.class);
        when(requestBodySpec2.accept(isA(MediaType[].class))).thenReturn(requestBodySpec);
        WebClient.RequestBodySpec requestBodySpec3 = mock(WebClient.RequestBodySpec.class);
        when(requestBodySpec3.header(Mockito.<String>any(), isA(String[].class))).thenReturn(requestBodySpec2);
        WebClient.RequestBodySpec requestBodySpec4 = mock(WebClient.RequestBodySpec.class);
        when(requestBodySpec4.header(Mockito.<String>any(), isA(String[].class))).thenReturn(requestBodySpec3);
        WebClient.RequestBodyUriSpec requestBodyUriSpec = mock(WebClient.RequestBodyUriSpec.class);
        when(requestBodyUriSpec.uri(Mockito.<String>any(), isA(Object[].class))).thenReturn(requestBodySpec4);
        WebClient webClient = mock(WebClient.class);
        when(webClient.post()).thenReturn(requestBodyUriSpec);
        WebClient.Builder webClientBuilder = mock(WebClient.Builder.class);
        when(webClientBuilder.build()).thenReturn(webClient);
        WhatsappService whatsappService = new WhatsappService(webClientBuilder, new Credentials());

        // Act
        MessageResponse actualSendWhatsappMessageResult = whatsappService
                .sendWhatsappMessage(new MessageRequest("Messaging product", "alice.liddell@example.org", "Type",
                        new MessageRequest.WhatsappTemplate("Name", new MessageRequest.WhatsappTemplate.Language("Code"))));

        // Assert
        verify(webClient).post();
        verify(webClientBuilder).build();
        verify(requestBodySpec).bodyValue(Mockito.<Object>any());
        verify(requestBodySpec2).accept(isA(MediaType[].class));
        verify(requestBodySpec4).header(eq("Authorization"), isA(String[].class));
        verify(requestBodySpec3).header(eq("Content-Type"), isA(String[].class));
        verify(requestHeadersSpec).retrieve();
        verify(responseSpec).bodyToMono(Mockito.<Class<MessageResponse>>any());
        verify(requestBodyUriSpec).uri(eq("nullnull/messages"), isA(Object[].class));
        assertSame(messageResponse, actualSendWhatsappMessageResult);
    }

    /**
     * Method under test:
     * {@link WhatsappService#sendWhatsappMessage(MessageRequest)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testSendWhatsappMessage2() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: Failed to create Spring context.
        //   Attempt to initialize test context failed with
        //   com.diffblue.fuzztest.shared.proxy.LibraryLinkageException: java.lang.reflect.GenericSignatureFormatError: Signature Parse error: expected '<' or ';' but got .
        //   	Remaining input: .Builder;
        //       at java.base/java.util.Optional.map(Optional.java:260)
        //   java.lang.reflect.GenericSignatureFormatError: Signature Parse error: expected '<' or ';' but got .
        //   	Remaining input: .Builder;
        //       at org.springframework.boot.test.mock.mockito.DefinitionsParser.getOrDeduceTypes(DefinitionsParser.java:119)
        //       at org.springframework.boot.test.mock.mockito.DefinitionsParser.parseMockBeanAnnotation(DefinitionsParser.java:79)
        //       at org.springframework.boot.test.mock.mockito.DefinitionsParser.lambda$parseElement$1(DefinitionsParser.java:72)
        //       at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
        //       at java.base/java.util.stream.ReferencePipeline$3$1.accept(ReferencePipeline.java:197)
        //       at org.springframework.core.annotation.TypeMappedAnnotations$AggregatesSpliterator.tryAdvance(TypeMappedAnnotations.java:607)
        //       at org.springframework.core.annotation.TypeMappedAnnotations$AggregatesSpliterator.tryAdvance(TypeMappedAnnotations.java:574)
        //       at java.base/java.util.Spliterator.forEachRemaining(Spliterator.java:332)
        //       at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:509)
        //       at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:499)
        //       at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
        //       at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
        //       at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
        //       at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:596)
        //       at org.springframework.boot.test.mock.mockito.DefinitionsParser.parseElement(DefinitionsParser.java:72)
        //       at org.springframework.boot.test.mock.mockito.DefinitionsParser.lambda$parse$0(DefinitionsParser.java:65)
        //       at org.springframework.util.ReflectionUtils.doWithFields(ReflectionUtils.java:728)
        //       at org.springframework.util.ReflectionUtils.doWithFields(ReflectionUtils.java:707)
        //       at org.springframework.boot.test.mock.mockito.DefinitionsParser.parse(DefinitionsParser.java:65)
        //       at org.springframework.boot.test.mock.mockito.MockitoContextCustomizerFactory.parseDefinitions(MockitoContextCustomizerFactory.java:44)
        //       at org.springframework.boot.test.mock.mockito.MockitoContextCustomizerFactory.createContextCustomizer(MockitoContextCustomizerFactory.java:39)
        //       at org.springframework.test.context.support.AbstractTestContextBootstrapper.getContextCustomizers(AbstractTestContextBootstrapper.java:360)
        //       at org.springframework.test.context.support.AbstractTestContextBootstrapper.buildMergedContextConfiguration(AbstractTestContextBootstrapper.java:332)
        //       at org.springframework.test.context.support.AbstractTestContextBootstrapper.buildMergedContextConfiguration(AbstractTestContextBootstrapper.java:244)
        //       at org.springframework.test.context.support.AbstractTestContextBootstrapper.buildTestContext(AbstractTestContextBootstrapper.java:108)
        //       at org.springframework.test.context.TestContextManager.<init>(TestContextManager.java:142)
        //       at org.springframework.test.context.TestContextManager.<init>(TestContextManager.java:126)
        //       at java.base/java.util.Optional.map(Optional.java:260)
        //   See https://diff.blue/R026 to resolve this issue.

        // Arrange and Act
        whatsappService.sendWhatsappMessage(new MessageRequest("Messaging product", "alice.liddell@example.org", "Type",
                new MessageRequest.WhatsappTemplate("Name", new MessageRequest.WhatsappTemplate.Language("Code"))));
    }
}
