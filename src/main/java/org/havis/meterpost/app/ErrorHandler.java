package org.havis.meterpost.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;

import java.util.stream.Stream;

@RestControllerAdvice
public class ErrorHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(ErrorHandler.class);

    @ExceptionHandler(HttpClientErrorException.class)
    public ResponseEntity<ErrorResponse> handleHttpClientError(final HttpClientErrorException e) {
        LOGGER.warn("Http client error '{}' occurred at {}", e.getMessage(), getFirstAppSourceInStack(e));

        return ResponseEntity
            .status(e.getStatusCode())
            .body(new ErrorResponse(
                e.getStatusCode().value(),
                e.getStatusCode().toString(),
                e.getStatusText()));
    }

    private String getFirstAppSourceInStack(final HttpClientErrorException e) {
        return Stream.of(e.getStackTrace())
            .map(Object::toString)
            .filter(s -> s.startsWith("org.havis"))
            .findFirst()
            .orElseGet(() -> {
                final StackTraceElement element = e.getStackTrace()[0];
                return element.toString();
            });
    }
}