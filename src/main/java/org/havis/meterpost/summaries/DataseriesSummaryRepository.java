package org.havis.meterpost.summaries;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface DataseriesSummaryRepository extends ReactiveCrudRepository<DataseriesSummary, Long> {
    Mono<DataseriesSummary> findByDataseriesId(final Long dataseriesId);
}
