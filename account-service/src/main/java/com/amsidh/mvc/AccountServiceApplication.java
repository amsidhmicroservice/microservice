package com.amsidh.mvc;

import com.amsidh.mvc.model.AccountModel;
import com.amsidh.mvc.service.AccountService;
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
public class AccountServiceApplication implements CommandLineRunner {

    private final AccountService accountService;

    public static void main(String[] args) {
        SpringApplication.run(AccountServiceApplication.class, args);
    }

    @Override
    public void run(String... args) {
        AccountModel accountModel = AccountModel.builder().accountNumber(98363365212L).accountType("Saving").build();
        accountService.saveAccount(accountModel);
        log.info("Number of account saved {}", accountService.getAccounts());
    }


}
