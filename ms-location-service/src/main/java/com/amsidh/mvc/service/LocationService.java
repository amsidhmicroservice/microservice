package com.amsidh.mvc.service;

import com.amsidh.mvc.model.LocationModel;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

public interface LocationService {
    @Cacheable(cacheNames = "locationCache", key = "#result.locationId")
    LocationModel saveLocation(LocationModel locationModel);

    @Cacheable(cacheNames = "locationCache", key = "#locationId")
    LocationModel getLocation(Long locationId);

    @CachePut(cacheNames = "locationCache", key = "#result.locationId")
    LocationModel updateLocation(Long locationId, LocationModel locationModel);

    @CacheEvict(cacheNames = "locationCache", key = "#locationId")
    void deleteLocation(Long locationId);

    List<LocationModel> getAllLocations();
}
