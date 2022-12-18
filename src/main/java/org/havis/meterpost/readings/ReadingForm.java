package org.havis.meterpost.readings;

import jakarta.validation.constraints.NotNull;

public record ReadingForm(
    @NotNull ReadingDTO reading,
    @NotNull String apiKey
) {
}
