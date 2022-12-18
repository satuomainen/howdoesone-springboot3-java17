package org.havis.meterpost.readings;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface ReadingRepository extends ReactiveCrudRepository<Reading, Long> {
    @Query("""
            SELECT r.id, r.created_at, r.updated_at, r.value, r.dataseries_id
            FROM readings r 
            WHERE r.dataseries_id = :dataseriesId 
            ORDER BY r.created_at 
            DESC LIMIT :limit
        """)
    Flux<Reading> findLatestByDataseriesId(long dataseriesId, long limit);
}
