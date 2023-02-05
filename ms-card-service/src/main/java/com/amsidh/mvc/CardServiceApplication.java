package com.amsidh.mvc;

import com.amsidh.mvc.entity.Card;
import com.amsidh.mvc.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.core.env.Environment;

import java.util.List;

@RequiredArgsConstructor
@SpringBootApplication
@EnableDiscoveryClient
@Slf4j
public class CardServiceApplication implements CommandLineRunner {

    private final CardRepository cardRepository;
    private final Environment environment;
    public static void main(String[] args) {
        SpringApplication.run(CardServiceApplication.class, args);
    }

    @Override
    public void run(String... args) {
        List<Card> savedCards = cardRepository.findAll();
        log.info("Number of card saved are {}", savedCards.size());


    }
}
