package com.amsidh.mvc.service;

import com.amsidh.mvc.model.AddressModel;

import java.util.List;

public interface AddressService {
    AddressModel saveAddress(AddressModel addressModel);

    AddressModel getAddressByAddressId(Long addressId);

    AddressModel updateAddress(Long addressId, AddressModel addressModel);

    void deleteAddress(Long addressId);

    List<AddressModel> getAddresses();

}
