package com.amsidh.mvc.service.impl;

import com.amsidh.mvc.entity.Account;
import com.amsidh.mvc.exception.AccountNotFoundException;
import com.amsidh.mvc.model.AccountModel;
import com.amsidh.mvc.repository.AccountRepository;
import com.amsidh.mvc.service.AccountService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Slf4j
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;
    private final ObjectMapper objectMapper;

    @Override
    public AccountModel saveAccount(AccountModel accountModel) {
        Account account = objectMapper.convertValue(accountModel, Account.class);
        Account savedAccount = accountRepository.saveAndFlush(account);
        return objectMapper.convertValue(savedAccount, AccountModel.class);
    }

    @Override
    public AccountModel getAccountById(Long accountId) {
        Account account = accountRepository.findById(accountId).orElseThrow(() -> new AccountNotFoundException(String.format("Account with accountId %d not found", accountId)));
        return objectMapper.convertValue(account, AccountModel.class);
    }

    @Override
    public AccountModel updateAccount(Long accountId, AccountModel accountModel) {
        AccountModel existingAccountModel = getAccountById(accountId);
        Optional.ofNullable(accountModel.getAccountNumber()).ifPresent(existingAccountModel::setAccountNumber);
        Optional.ofNullable(accountModel.getAccountType()).ifPresent(existingAccountModel::setAccountType);
        return saveAccount(existingAccountModel);
    }

    @Override
    public void deleteAccount(Long accountId) {
        accountRepository.deleteById(accountId);
    }

    @Override
    public List<AccountModel> getAccounts() {
        return objectMapper.convertValue(accountRepository.findAll(), new TypeReference<>() {
        });
    }
}
