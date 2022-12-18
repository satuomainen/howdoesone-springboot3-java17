package org.havis.meterpost.summaries;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(path = "/dataseries/summaries")
public class DataseriesSummaryController {

    private final DataseriesSummaryService dataseriesSummaryService;

    public DataseriesSummaryController(DataseriesSummaryService dataseriesSummaryService) {
        this.dataseriesSummaryService = dataseriesSummaryService;
    }

    @GetMapping()
    public Flux<DataseriesSummaryDTO> get() {
        return dataseriesSummaryService.getAll();
    }

    @GetMapping(path = "/{dataseriesId:\\d+}")
    public Mono<DataseriesSummaryDTO> getOne(@PathVariable(name="dataseriesId") final long dataseriesId) {
        return dataseriesSummaryService.getOne(dataseriesId);
    }
}
