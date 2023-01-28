package com.amsidh.mvc.client.feign;

import com.amsidh.mvc.config.FeignClientConfig;
import com.amsidh.mvc.model.AddressModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-address-service", url = "${feign.client.url.ms-address-service}", configuration = FeignClientConfig.class)
public interface AddressFeignClient {

    @GetMapping("/addresses/{addressId}")
    AddressModel getAddressByAddressId(@PathVariable("addressId") Long addressId);
}
