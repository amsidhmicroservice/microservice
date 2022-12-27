package com.amsidh.mvc.controller;

import com.amsidh.mvc.model.LocationModel;
import com.amsidh.mvc.service.LocationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping("/locations")
public class LocationController {
    private final LocationService locationService;

    @GetMapping
    public List<LocationModel> getAllLocations() {
        return locationService.getAllLocations();
    }

    @GetMapping("/{locationId}")
    public LocationModel getLocationByLocationId(@PathVariable("locationId") Long locationId) {
        return locationService.getLocation(locationId);
    }

    @PostMapping
    public LocationModel saveLocation(@RequestBody @Validated LocationModel locationModel) {
        return locationService.saveLocation(locationModel);
    }

    @PutMapping("/{locationId}")
    public LocationModel updateLocation(@PathVariable("locationId") Long locationId, @RequestBody @Validated LocationModel locationModel) {
        return locationService.updateLocation(locationId, locationModel);
    }

    @DeleteMapping("/{locationId}")
    public ResponseEntity<String> deleteLocation(@PathVariable("locationId") Long locationId) {
        locationService.deleteLocation(locationId);
        return ResponseEntity.ok(String.format("Location with locationId %d deleted successfully", locationId));
    }
}
