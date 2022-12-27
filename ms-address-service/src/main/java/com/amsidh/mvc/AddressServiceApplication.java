package com.amsidh.mvc;

import com.amsidh.mvc.entity.Address;
import com.amsidh.mvc.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
@SpringBootApplication
@EnableFeignClients
@Slf4j
public class AddressServiceApplication implements CommandLineRunner {
    private final AddressRepository addressRepository;

    public static void main(String[] args) {
        SpringApplication.run(AddressServiceApplication.class, args);
    }

    @Override
    public void run(String... args) {
        log.info("Cleaning Address table");
        addressRepository.deleteAll();
        List<Address> addresses = Arrays.asList(Address.builder().addressId(1l).city("Pune").state("Maharashtra").build(), Address.builder().addressId(2l).city("Mumbai").state("Maharashtra").build(), Address.builder().addressId(3l).city("Bijapur").state("Maharashtra").build(), Address.builder().addressId(4l).city("Satara").state("Maharashtra").build(), Address.builder().addressId(5l).city("PWC").state("Maharashtra").build(), Address.builder().addressId(6l).city("Sangli").state("Maharashtra").build(), Address.builder().addressId(7l).city("Karad").state("Maharashtra").build(), Address.builder().addressId(8l).city("Kolhapur").state("Maharashtra").build(), Address.builder().addressId(9l).city("Solapur").state("Maharashtra").build(), Address.builder().addressId(10l).city("Panel").state("Maharashtra").build());
        List<Address> savedAddresses = addressRepository.saveAll(addresses);
        log.info("Number of address saved are {}", savedAddresses.size());
    }
}
