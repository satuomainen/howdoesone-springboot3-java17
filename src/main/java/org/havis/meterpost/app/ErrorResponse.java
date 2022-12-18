package org.havis.meterpost.app;

public record ErrorResponse(
    int statusCode,
    String error,
    String message
) {
}
