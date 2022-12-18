package org.havis.meterpost.readings;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping(path = "/dataseries")
public class ReadingController {

    private final ReadingService readingService;

    public ReadingController(final ReadingService readingService) {
        this.readingService = readingService;
    }

    @GetMapping(path = "/{dataseriesId:\\d+}/readings")
    public Flux<ReadingDTO> get(
        @PathVariable(name = "dataseriesId") final long dataseriesId,
        @RequestParam(name = "limit", defaultValue = "100") @Max(500) @Min(1) final long limit
    ) {
        return readingService.getLatest(dataseriesId, limit);
    }
}
