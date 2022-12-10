package com.amsidh.mvc;

import com.amsidh.mvc.entity.Card;
import com.amsidh.mvc.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
@SpringBootApplication
@EnableDiscoveryClient
@Slf4j
public class CardServiceApplication implements CommandLineRunner {

    private final CardRepository cardRepository;

    public static void main(String[] args) {
        SpringApplication.run(CardServiceApplication.class, args);
    }

    @Override
    public void run(String... args) {
        log.info("Cleaning Card table");
        cardRepository.deleteAll();
        List<Card> cards = Arrays.asList(
                Card.builder().cardId(1l).cardNumber(989678567487945461L).cardType("Credit").build(),
                Card.builder().cardId(2l).cardNumber(989678567487945462L).cardType("Debit").build(),
                Card.builder().cardId(3l).cardNumber(989678567487945463L).cardType("Smart").build(),
                Card.builder().cardId(4l).cardNumber(989678567487945464L).cardType("Food").build(),
                Card.builder().cardId(5l).cardNumber(989678567487945465L).cardType("Credit").build(),
                Card.builder().cardId(6l).cardNumber(989678567487945466L).cardType("Debit").build(),
                Card.builder().cardId(7l).cardNumber(989678567487945467L).cardType("Credit").build(),
                Card.builder().cardId(8l).cardNumber(989678567487945468L).cardType("Food").build(),
                Card.builder().cardId(9l).cardNumber(989678567487945469L).cardType("Credit").build(),
                Card.builder().cardId(10l).cardNumber(989678567487945410L).cardType("Smart").build()
        );
        List<Card> savedCards = cardRepository.saveAll(cards);
        log.info("Number of card saved are {}", savedCards.size());
    }
}
