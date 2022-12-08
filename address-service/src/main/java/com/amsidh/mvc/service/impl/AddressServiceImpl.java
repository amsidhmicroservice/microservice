package com.amsidh.mvc.service.impl;

import com.amsidh.mvc.entity.Address;
import com.amsidh.mvc.exception.AddressNotFoundException;
import com.amsidh.mvc.model.AddressModel;
import com.amsidh.mvc.repository.AddressRepository;
import com.amsidh.mvc.service.AddressService;
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
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;
    private final ObjectMapper objectMapper;

    @Override
    public AddressModel saveAddress(AddressModel addressModel) {
        Address address = objectMapper.convertValue(addressModel, Address.class);
        Address savedAddress = addressRepository.save(address);
        return objectMapper.convertValue(savedAddress, AddressModel.class);
    }

    @Override
    public AddressModel getAddressByAddressId(Long addressId) {
        return objectMapper.convertValue(addressRepository.findById(addressId).orElseThrow(() -> new AddressNotFoundException(String.format("Address with addressId %d not found", addressId))), AddressModel.class);
    }

    @Override
    public AddressModel updateAddress(Long addressId, AddressModel addressModel) {
        AddressModel exitingAddressModel = getAddressByAddressId(addressId);
        Optional.ofNullable(addressModel.getCity()).ifPresent(exitingAddressModel::setCity);
        Optional.ofNullable(addressModel.getState()).ifPresent(exitingAddressModel::setState);
        return saveAddress(exitingAddressModel);
    }

    @Override
    public void deleteAddress(Long addressId) {
        addressRepository.deleteById(addressId);
    }

    @Override
    public List<AddressModel> getAddresses() {
        return objectMapper.convertValue(addressRepository.findAll(), new TypeReference<>() {
        });
    }
}
