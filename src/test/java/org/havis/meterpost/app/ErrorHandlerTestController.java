package org.havis.meterpost.app;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

@RestController
@RequestMapping(path = "/error-test")
public class ErrorHandlerTestController {
    @GetMapping
    public String errorTest(
        @RequestParam("statusCode") final Integer statusCode,
        @RequestParam("message") final String message
    ) {
        throw new HttpClientErrorException(HttpStatus.valueOf(statusCode), message);
    }
}
