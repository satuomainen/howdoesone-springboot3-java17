package org.havis.meterpost.readings;

import org.havis.meterpost.dataseries.Dataseries;
import org.havis.meterpost.dataseries.DataseriesRepository;
import org.havis.meterpost.summaries.DataseriesSummaryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Objects;

@Service
public class ReadingService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ReadingService.class);

    private final DataseriesRepository dataseriesRepository;
    private final DataseriesSummaryRepository dataseriesSummaryRepository;
    private final ReadingRepository readingRepository;

    public ReadingService(
        final DataseriesRepository dataseriesRepository,
        final DataseriesSummaryRepository dataseriesSummaryRepository,
        final ReadingRepository readingRepository
    ) {
        this.dataseriesRepository = dataseriesRepository;
        this.dataseriesSummaryRepository = dataseriesSummaryRepository;
        this.readingRepository = readingRepository;
    }

    public Flux<ReadingDTO> getLatest(long dataseriesId, long limit) {
        LOGGER.info("Get latest reading for dataseries #{}, limit={}", dataseriesId, limit);

        return readingRepository.findLatestByDataseriesId(dataseriesId, limit).map(ReadingDTOMapper::map);
    }

    public Mono<ReadingDTO> addReading(final long dataseriesId, final ReadingForm readingForm) {
        ensureDataseriesIdsMatch(dataseriesId, readingForm);

        LOGGER.info("Add reading to dataseries #{}", dataseriesId);

        return dataseriesRepository
            .findById(dataseriesId)
            .map(dataseries -> validateApiKey(dataseries, readingForm))
            .map(this::createEntity)
            .flatMap(readingRepository::save)
            .flatMap(this::updateSummary)
            .map(ReadingDTOMapper::map);

    }

    private Reading createEntity(final ReadingDTO reading) {
        final OffsetDateTime now = OffsetDateTime.now();

        return Reading.ReadingBuilder.aReading()
            .withCreatedAt(now)
            .withUpdatedAt(now)
            .withValue(reading.value())
            .withDataseriesId(reading.dataseriesId())
            .build();
    }

    private Mono<Reading> updateSummary(final Reading reading) {
        return dataseriesSummaryRepository
            .findByDataseriesId(reading.getDataseriesId())
            .flatMap(dataseriesSummary -> {
                dataseriesSummary.setUpdatedAt(OffsetDateTime.now());
                dataseriesSummary.setCurrentValue(reading.getValue());
                dataseriesSummary.setMinValue(minimumOf(dataseriesSummary.getMinValue(), reading.getValue()));
                dataseriesSummary.setMaxValue(maximumOf(dataseriesSummary.getMaxValue(), reading.getValue()));

                return dataseriesSummaryRepository.save(dataseriesSummary);
            })
            .map(dataseriesSummary -> reading);
    }

    static String minimumOf(final String left, final String right) {
        try {
            final BigDecimal l = new BigDecimal(left);
            final BigDecimal r = new BigDecimal(right);
            if (l.compareTo(r) < 0) {
                return left;
            }
            return right;
        } catch (NumberFormatException e) {
            if (left.compareTo(right) < 0) {
                return left;
            }
            return right;
        }
    }

    static String maximumOf(final String left, final String right) {
        try {
            final BigDecimal l = new BigDecimal(left);
            final BigDecimal r = new BigDecimal(right);
            if (l.compareTo(r) > 0) {
                return left;
            }
            return right;
        } catch (NumberFormatException e) {
            if (left.compareTo(right) > 0) {
                return left;
            }
            return right;
        }
    }

    private ReadingDTO validateApiKey(final Dataseries dataseries, final ReadingForm readingForm) {
        if (Objects.isNull(dataseries)) {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND, "Dataseries not found");
        }

        if (!Objects.equals(dataseries.getApiKey(), readingForm.apiKey())) {
            throw new HttpClientErrorException(HttpStatus.UNAUTHORIZED, "Unauthorized");
        }

        return readingForm.reading();
    }


    private void ensureDataseriesIdsMatch(final long dataseriesId, final ReadingForm readingForm) {
        if (!Objects.equals(readingForm.reading().dataseriesId(), dataseriesId)) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Dataseries id mismatch");
        }
    }
}
