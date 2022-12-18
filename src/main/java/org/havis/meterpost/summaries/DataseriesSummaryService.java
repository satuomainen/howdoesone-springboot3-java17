package org.havis.meterpost.summaries;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public class DataseriesSummaryService {
    private static final Logger LOGGER = LoggerFactory.getLogger(DataseriesSummaryService.class);

    private final DataseriesSummaryRepository dataseriesRepository;

    public DataseriesSummaryService(DataseriesSummaryRepository dataseriesRepository) {
        this.dataseriesRepository = dataseriesRepository;
    }

    public Flux<DataseriesSummaryDTO> getAll() {
        LOGGER.info("Get all dataseries summaries");

        return dataseriesRepository.findAll().map(DataseriesSummaryDTOMapper::map);
    }

    public Mono<DataseriesSummaryDTO> getOne(final Long dataseriesId) {
        LOGGER.info("Get dataseries summaries #{}", dataseriesId);

        return dataseriesRepository.findById(dataseriesId).map(DataseriesSummaryDTOMapper::map);
    }
}
