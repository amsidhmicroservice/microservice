package com.amsidh.mvc;

import com.amsidh.mvc.model.LocationModel;
import com.amsidh.mvc.service.LocationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@RequiredArgsConstructor
@SpringBootApplication
@Slf4j
public class LocationServiceApplication implements CommandLineRunner {

    private final LocationService locationService;

    public static void main(String[] args) {
        SpringApplication.run(LocationServiceApplication.class, args);
    }

    @Override
    public void run(String... args) {
        LocationModel locationModel = LocationModel.builder().longitude(98797.6767).latitude(986896.567).build();
        locationService.saveLocation(locationModel);
        log.info("Number of location saved are {}", locationService.getAllLocations().size());
        log.info("Loading successfully");
    }
}
