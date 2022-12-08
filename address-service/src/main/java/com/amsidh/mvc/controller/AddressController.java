package com.amsidh.mvc.controller;

import com.amsidh.mvc.client.feign.LocationServiceFeignClient;
import com.amsidh.mvc.model.AddressModel;
import com.amsidh.mvc.model.LocationModel;
import com.amsidh.mvc.service.AddressService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping("/addresses")
public class AddressController {
    private final AddressService addressService;
    private final LocationServiceFeignClient locationServiceFeignClient;

    @GetMapping
    public List<AddressModel> getAllAddresses() {
        return addressService.getAddresses();
    }

    @GetMapping("{addressId}")
    public AddressModel getAddressByAddressId(@PathVariable("addressId") Long addressId) {
        AddressModel addressModel = addressService.getAddressByAddressId(addressId);
        LocationModel locationModel = locationServiceFeignClient.findLocationByLocationId(1L);
        addressModel.setLocationModel(locationModel);
        return addressModel;
    }

    @PostMapping
    public AddressModel registerAddress(@RequestBody @Validated AddressModel addressModel) {
        return addressService.saveAddress(addressModel);
    }

    @PutMapping("{addressId}")
    public AddressModel updateAddress(@PathVariable("addressId") Long addressId, @RequestBody @Validated AddressModel addressModel) {
        return addressService.updateAddress(addressId, addressModel);
    }

    @DeleteMapping("{addressId}")
    public ResponseEntity<String> deleteAddressByAddressId(@PathVariable("addressId") Long addressId) {
        addressService.deleteAddress(addressId);
        return ResponseEntity.ok(String.format("Address with addressId %d deleted successfully", addressId));
    }
}
