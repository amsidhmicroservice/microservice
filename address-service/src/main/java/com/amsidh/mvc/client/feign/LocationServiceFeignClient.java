package com.amsidh.mvc.client.feign;

import com.amsidh.mvc.config.FeignClientConfig;
import com.amsidh.mvc.model.LocationModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "location-service", configuration = FeignClientConfig.class)
public interface LocationServiceFeignClient {

    @GetMapping("/locations/{locationId}")
    LocationModel findLocationByLocationId(@PathVariable("locationId") Long locationId);
}
