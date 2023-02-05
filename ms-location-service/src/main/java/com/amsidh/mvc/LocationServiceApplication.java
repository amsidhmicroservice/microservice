package com.amsidh.mvc;

import com.amsidh.mvc.entity.Location;
import com.amsidh.mvc.repository.LocationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
@SpringBootApplication
@Slf4j
public class LocationServiceApplication implements CommandLineRunner {

    private final LocationRepository locationRepository;

    public static void main(String[] args) {
        SpringApplication.run(LocationServiceApplication.class, args);
    }

    @Override
    public void run(String... args) {
        log.info("Cleaning Location table");
        locationRepository.deleteAll();
        List<Location> locations = Arrays.asList(Location.builder().locationId(1l).longitude(98791.6767).latitude(986896.5671).build(),
                Location.builder().locationId(2l).longitude(98792.6767).latitude(986896.5672).build(),
                Location.builder().locationId(3l).longitude(98793.6767).latitude(986896.5673).build(),
                Location.builder().locationId(4l).longitude(98794.6767).latitude(986896.5674).build(),
                Location.builder().locationId(5l).longitude(98795.6767).latitude(986896.5675).build(),
                Location.builder().locationId(6l).longitude(98796.6767).latitude(986896.5676).build(),
                Location.builder().locationId(7l).longitude(98797.6767).latitude(986896.5677).build(),
                Location.builder().locationId(8l).longitude(98798.6767).latitude(986896.5678).build(),
                Location.builder().locationId(9l).longitude(98799.6767).latitude(986896.5679).build(),
                Location.builder().locationId(10l).longitude(98710.6767).latitude(986896.5610).build());
        List<Location> savedLocations = locationRepository.saveAll(locations);
        log.info("Number of location saved are {}", savedLocations.size());
        log.info("Loading successfully");
    }
}
