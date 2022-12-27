package com.amsidh.mvc.service.impl;

import com.amsidh.mvc.entity.Location;
import com.amsidh.mvc.exception.LocationNotFoundException;
import com.amsidh.mvc.model.LocationModel;
import com.amsidh.mvc.repository.LocationRepository;
import com.amsidh.mvc.service.LocationService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Slf4j
@Service
public class LocationServiceImpl implements LocationService {
    private final LocationRepository locationRepository;
    private final ObjectMapper objectMapper;

    @Override
    public LocationModel saveLocation(LocationModel locationModel) {
        Location location = objectMapper.convertValue(locationModel, Location.class);
        Location savedLocation = locationRepository.saveAndFlush(location);
        return objectMapper.convertValue(savedLocation, LocationModel.class);
    }

    @Override
    public LocationModel getLocation(Long locationId) {
        Location location = locationRepository.findById(locationId).orElseThrow(() -> new LocationNotFoundException(String.format("Location with locationId %d not found", locationId)));
        return objectMapper.convertValue(location, LocationModel.class);
    }

    @Override
    public LocationModel updateLocation(Long locationId, LocationModel locationModel) {
        LocationModel existingLocationModel = getLocation(locationId);
        Optional.ofNullable(locationModel.getLongitude()).ifPresent(existingLocationModel::setLongitude);
        Optional.ofNullable(locationModel.getLatitude()).ifPresent(existingLocationModel::setLatitude);
        return saveLocation(existingLocationModel);
    }

    @Override
    public void deleteLocation(Long locationId) {
        locationRepository.deleteById(locationId);
    }

    @Override
    public List<LocationModel> getAllLocations() {
        return objectMapper.convertValue(locationRepository.findAll(), new TypeReference<>() {
        });
    }
}
