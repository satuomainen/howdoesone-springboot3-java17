package org.havis.meterpost.readings;

import jakarta.validation.constraints.Size;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.OffsetDateTime;

@Table(name = "readings")
public class Reading {
    @Id
    private Long id;

    @Column("created_at")
    private OffsetDateTime createdAt;

    @Column("updated_at")
    private OffsetDateTime updatedAt;

    @Column("value")
    @Size(max = 255)
    private String value;

    @Column("dataseries_id")
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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Long getDataseriesId() {
        return dataseriesId;
    }

    public void setDataseriesId(Long dataseriesId) {
        this.dataseriesId = dataseriesId;
    }

    public static final class ReadingBuilder {
        private Long id;
        private OffsetDateTime createdAt;
        private OffsetDateTime updatedAt;
        private @Size(max = 255) String value;
        private Long dataseriesId;

        private ReadingBuilder() {
        }

        public static ReadingBuilder aReading() {
            return new ReadingBuilder();
        }

        public ReadingBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public ReadingBuilder withCreatedAt(OffsetDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public ReadingBuilder withUpdatedAt(OffsetDateTime updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        public ReadingBuilder withValue(String value) {
            this.value = value;
            return this;
        }

        public ReadingBuilder withDataseriesId(Long dataseriesId) {
            this.dataseriesId = dataseriesId;
            return this;
        }

        public Reading build() {
            Reading reading = new Reading();
            reading.setId(id);
            reading.setCreatedAt(createdAt);
            reading.setUpdatedAt(updatedAt);
            reading.setValue(value);
            reading.setDataseriesId(dataseriesId);
            return reading;
        }
    }
}
