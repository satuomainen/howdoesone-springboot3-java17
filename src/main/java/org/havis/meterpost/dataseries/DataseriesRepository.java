package org.havis.meterpost.dataseries;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface DataseriesRepository extends ReactiveCrudRepository<Dataseries, Long> {
}
