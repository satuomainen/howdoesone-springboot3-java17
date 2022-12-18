package org.havis.meterpost.readings;

interface ReadingDTOMapper {
    static ReadingDTO map(final Reading reading) {
        return new ReadingDTO(
            reading.getId(),
            reading.getCreatedAt(),
            reading.getUpdatedAt(),
            reading.getValue(),
            reading.getDataseriesId());
    }
}
