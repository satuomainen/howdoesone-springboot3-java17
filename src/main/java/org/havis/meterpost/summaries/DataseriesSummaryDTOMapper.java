package org.havis.meterpost.summaries;

interface DataseriesSummaryDTOMapper {
    static DataseriesSummaryDTO map(DataseriesSummary summary) {
        return DataseriesSummaryDTO.DataseriesSummaryDTOBuilder.aDataseriesSummaryDTO()
            .withId(summary.getId())
            .withCreatedAt(summary.getCreatedAt())
            .withUpdatedAt(summary.getUpdatedAt())
            .withCurrentValue(summary.getCurrentValue())
            .withMinValue(summary.getMinValue())
            .withMaxValue(summary.getMaxValue())
            .withDataseriesId(summary.getDataseriesId())
            .build();
    }
}
