package com.amsidh.mvc;

import com.amsidh.mvc.entity.Account;
import com.amsidh.mvc.repository.AccountRepository;
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
public class AccountServiceApplication implements CommandLineRunner {

    private final AccountRepository accountRepository;

    public static void main(String[] args) {
        SpringApplication.run(AccountServiceApplication.class, args);
    }

    @Override
    public void run(String... args) {
        log.info("Cleaning Account table");
        accountRepository.deleteAll();
        List<Account> accounts = Arrays.asList(Account.builder().accountId(1l).accountNumber(98363365211L).accountType("Saving").build(), Account.builder().accountId(2l).accountNumber(98363365212L).accountType("Loan").build(), Account.builder().accountId(3l).accountNumber(98363365213L).accountType("Overdraft").build(), Account.builder().accountId(4l).accountNumber(98363365214L).accountType("Salary").build(), Account.builder().accountId(5l).accountNumber(98363365215L).accountType("Demat").build(), Account.builder().accountId(6l).accountNumber(98363365216L).accountType("FD").build(), Account.builder().accountId(7l).accountNumber(98363365217L).accountType("Overdraft").build(), Account.builder().accountId(8l).accountNumber(98363365218L).accountType("Saving").build(), Account.builder().accountId(9l).accountNumber(98363365219L).accountType("Loan").build(), Account.builder().accountId(10l).accountNumber(98363365210L).accountType("Salary").build());
        List<Account> savedAccounts = accountRepository.saveAll(accounts);
        log.info("Number of account saved {}", savedAccounts.size());
    }


}
