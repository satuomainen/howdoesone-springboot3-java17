package org.havis.meterpost.readings;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;


@Service
public class ReadingService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ReadingService.class);

    private final ReadingRepository readingRepository;

    public ReadingService(ReadingRepository readingRepository) {
        this.readingRepository = readingRepository;
    }

    public Flux<ReadingDTO> getLatest(long dataseriesId, long limit) {
        LOGGER.info("Get latest reading for dataseries #{}, limit={}", dataseriesId, limit);

        return readingRepository.findLatestByDataseriesId(dataseriesId, limit).map(ReadingDTOMapper::map);
    }
}
