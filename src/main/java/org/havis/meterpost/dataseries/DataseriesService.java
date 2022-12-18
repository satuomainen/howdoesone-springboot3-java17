package org.havis.meterpost.dataseries;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public class DataseriesService {
    private static final Logger LOGGER = LoggerFactory.getLogger(DataseriesService.class);

    private final DataseriesRepository dataseriesRepository;

    public DataseriesService(DataseriesRepository dataseriesRepository) {
        this.dataseriesRepository = dataseriesRepository;
    }

    public Flux<DataseriesDTO> getAll() {
        LOGGER.info("Get all dataseries");

        return dataseriesRepository.findAll().map(DataseriesDTOMapper::map);
    }

    public Mono<DataseriesDTO> getOne(final Long dataseriesId) {
        LOGGER.info("Get dataseries #{}", dataseriesId);

        return dataseriesRepository.findById(dataseriesId).map(DataseriesDTOMapper::map);
    }
}
