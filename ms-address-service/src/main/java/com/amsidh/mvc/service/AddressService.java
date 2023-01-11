package com.amsidh.mvc.service;

import com.amsidh.mvc.model.AddressModel;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

public interface AddressService {
    @Cacheable(cacheNames = "addressCache", key = "#result.addressId")
    AddressModel saveAddress(AddressModel addressModel);

    @Cacheable(cacheNames = "addressCache", key = "#addressId")
    AddressModel getAddressByAddressId(Long addressId);

    @CachePut(cacheNames = "addressCache", key = "#result.addressId")
    AddressModel updateAddress(Long addressId, AddressModel addressModel);

    @CacheEvict(cacheNames = "addressCache", key = "#addressId")
    void deleteAddress(Long addressId);

    List<AddressModel> getAddresses();

}
