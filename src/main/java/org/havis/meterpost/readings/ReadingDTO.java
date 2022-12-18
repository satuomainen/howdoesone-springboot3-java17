package org.havis.meterpost.readings;

import java.time.OffsetDateTime;

record ReadingDTO(
    Long id,
    OffsetDateTime createdAt,
    OffsetDateTime updatedAt,
    String value,
    Long dataseriesId
) {
}
