package com.amsidh.mvc;

import com.amsidh.mvc.model.AddressModel;
import com.amsidh.mvc.service.AddressService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@RequiredArgsConstructor
@SpringBootApplication
@EnableFeignClients
@Slf4j
public class AddressServiceApplication implements CommandLineRunner {
    private final AddressService addressService;

    public static void main(String[] args) {
        SpringApplication.run(AddressServiceApplication.class, args);
    }

    @Override
    public void run(String... args) {
        AddressModel addressModel = AddressModel.builder().city("Pune").state("Maharashtra").build();
        addressService.saveAddress(addressModel);
        log.info("Number of address saved are {}", addressService.getAddresses());
    }
}
