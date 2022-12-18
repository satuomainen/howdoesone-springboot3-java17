package org.havis.meterpost.dataseries;

import java.time.OffsetDateTime;

public class DataseriesDTO {
    private Long id;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;
    private String name;
    private String description;
    private String label;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public static final class DataseriesDTOBuilder {
        private Long id;
        private OffsetDateTime createdAt;
        private OffsetDateTime updatedAt;
        private String name;
        private String description;
        private String label;

        private DataseriesDTOBuilder() {
        }

        public static DataseriesDTOBuilder aDataseriesDTO() {
            return new DataseriesDTOBuilder();
        }

        public DataseriesDTOBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public DataseriesDTOBuilder withCreatedAt(OffsetDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public DataseriesDTOBuilder withUpdatedAt(OffsetDateTime updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        public DataseriesDTOBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public DataseriesDTOBuilder withDescription(String description) {
            this.description = description;
            return this;
        }

        public DataseriesDTOBuilder withLabel(String label) {
            this.label = label;
            return this;
        }

        public DataseriesDTO build() {
            DataseriesDTO dataseriesDTO = new DataseriesDTO();
            dataseriesDTO.setId(id);
            dataseriesDTO.setCreatedAt(createdAt);
            dataseriesDTO.setUpdatedAt(updatedAt);
            dataseriesDTO.setName(name);
            dataseriesDTO.setDescription(description);
            dataseriesDTO.setLabel(label);
            return dataseriesDTO;
        }
    }
}
