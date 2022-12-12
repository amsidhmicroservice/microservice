package com.amsidh.mvc.feign.logger;

import feign.Request;
import feign.Response;
import feign.Util;
import feign.slf4j.Slf4jLogger;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

import static feign.Util.decodeOrDefault;
import static java.nio.charset.StandardCharsets.UTF_8;

@Slf4j
@RequiredArgsConstructor
public class FeignCustomLogger extends Slf4jLogger {

    @Override
    protected void log(String configKey, String format, Object... args) {

    }
    @Override
    protected void logRequest(String configKey, Level logLevel, Request request) {
        log.info("Calling internal service with url {} and request body {}", request.url(), decodeOrDefault(request.body(), UTF_8, ""));
    }

    @Override
    protected Response logAndRebufferResponse(String configKey, Level logLevel, Response response, long elapsedTime) throws IOException {
        byte[] responseData = Util.toByteArray(response.body().asInputStream());
        log.info("Response received with body {}, httpStatus {}, reason {} and timeTaken {}ms", decodeOrDefault(responseData, UTF_8, ""), response.status(), response.reason(), elapsedTime);
        return response.toBuilder().body(responseData).build();
    }
}
