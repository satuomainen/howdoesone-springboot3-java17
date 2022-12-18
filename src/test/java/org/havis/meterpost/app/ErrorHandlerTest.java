package org.havis.meterpost.app;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ErrorHandlerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    void errorHandler_catches_httpClientErrorExceptions() {
        // Given
        final var expectedStatusCode = HttpStatus.I_AM_A_TEAPOT.value();
        final var expectedMessage = "random test string";
        final var url = String.format(
            "http://localhost:%d/error-test?statusCode=%s&message=%s",
            port,
            expectedStatusCode,
            expectedMessage);

        // When
        var responseEntity = testRestTemplate.getForEntity(url, String.class);

        // Then
        assertEquals(expectedStatusCode, responseEntity.getStatusCode().value());
        assertThat(responseEntity.getBody()).contains(expectedMessage);
    }
}