package com.amsidh.mvc.service;

import com.amsidh.mvc.model.LocationModel;

import java.util.List;

public interface LocationService {
    LocationModel saveLocation(LocationModel locationModel);

    LocationModel getLocation(Long locationId);

    LocationModel updateLocation(Long locationId, LocationModel locationModel);

    void deleteLocation(Long locationId);

    List<LocationModel> getAllLocations();
}
