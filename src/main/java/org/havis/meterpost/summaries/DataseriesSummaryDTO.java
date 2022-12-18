package org.havis.meterpost.summaries;

import java.time.OffsetDateTime;

public class DataseriesSummaryDTO {
    private Long id;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;
    private String currentValue;
    private String minValue;
    private String maxValue;
    private Long dataseriesId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public OffsetDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(OffsetDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(String currentValue) {
        this.currentValue = currentValue;
    }

    public String getMinValue() {
        return minValue;
    }

    public void setMinValue(String minValue) {
        this.minValue = minValue;
    }

    public String getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(String maxValue) {
        this.maxValue = maxValue;
    }

    public Long getDataseriesId() {
        return dataseriesId;
    }

    public void setDataseriesId(Long dataseriesId) {
        this.dataseriesId = dataseriesId;
    }


    public static final class DataseriesSummaryDTOBuilder {
        private Long id;
        private OffsetDateTime createdAt;
        private OffsetDateTime updatedAt;
        private String currentValue;
        private String minValue;
        private String maxValue;
        private Long dataseriesId;

        private DataseriesSummaryDTOBuilder() {
        }

        public static DataseriesSummaryDTOBuilder aDataseriesSummaryDTO() {
            return new DataseriesSummaryDTOBuilder();
        }

        public DataseriesSummaryDTOBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public DataseriesSummaryDTOBuilder withCreatedAt(OffsetDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public DataseriesSummaryDTOBuilder withUpdatedAt(OffsetDateTime updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        public DataseriesSummaryDTOBuilder withCurrentValue(String currentValue) {
            this.currentValue = currentValue;
            return this;
        }

        public DataseriesSummaryDTOBuilder withMinValue(String minValue) {
            this.minValue = minValue;
            return this;
        }

        public DataseriesSummaryDTOBuilder withMaxValue(String maxValue) {
            this.maxValue = maxValue;
            return this;
        }

        public DataseriesSummaryDTOBuilder withDataseriesId(Long dataseriesId) {
            this.dataseriesId = dataseriesId;
            return this;
        }

        public DataseriesSummaryDTO build() {
            DataseriesSummaryDTO dataseriesSummaryDTO = new DataseriesSummaryDTO();
            dataseriesSummaryDTO.setId(id);
            dataseriesSummaryDTO.setCreatedAt(createdAt);
            dataseriesSummaryDTO.setUpdatedAt(updatedAt);
            dataseriesSummaryDTO.setCurrentValue(currentValue);
            dataseriesSummaryDTO.setMinValue(minValue);
            dataseriesSummaryDTO.setMaxValue(maxValue);
            dataseriesSummaryDTO.setDataseriesId(dataseriesId);
            return dataseriesSummaryDTO;
        }
    }
}
