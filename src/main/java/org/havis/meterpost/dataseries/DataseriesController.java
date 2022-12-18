package org.havis.meterpost.dataseries;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(path = "/dataseries")
public class DataseriesController {

    private final DataseriesService dataseriesService;

    public DataseriesController(DataseriesService dataseriesService) {
        this.dataseriesService = dataseriesService;
    }

    @GetMapping
    public Flux<DataseriesDTO> getAll() {
        return dataseriesService.getAll();
    }

    @GetMapping(path = "/{dataseriesId:\\d+}")
    public Mono<DataseriesDTO> getOne(@PathVariable(name = "dataseriesId") final long dataseriesId) {
        return dataseriesService.getOne(dataseriesId);
    }
}
