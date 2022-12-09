package com.amsidh.mvc;

import com.amsidh.mvc.model.CardModel;
import com.amsidh.mvc.service.CardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@RequiredArgsConstructor
@SpringBootApplication
@EnableDiscoveryClient
@Slf4j
public class CardServiceApplication implements CommandLineRunner {

    private final CardService cardService;

    public static void main(String[] args) {
        SpringApplication.run(CardServiceApplication.class, args);
    }

    @Override
    public void run(String... args) {
        CardModel cardModel = CardModel.builder().cardNumber(989678567487945465L).cardType("Credit").build();
        cardService.saveCard(cardModel);
        log.info("Number of card saved are {}", cardService.getAllCards().size());
    }
}
