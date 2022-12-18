package org.havis.meterpost.dataseries;

interface DataseriesDTOMapper {
    static DataseriesDTO map(Dataseries dataseries) {
        return DataseriesDTO.DataseriesDTOBuilder.aDataseriesDTO()
            .withId(dataseries.getId())
            .withCreatedAt(dataseries.getCreatedAt())
            .withUpdatedAt(dataseries.getUpdatedAt())
            .withName(dataseries.getName())
            .withDescription(dataseries.getDescription())
            .withLabel(dataseries.getLabel())
            .build();
    }
}
