package com.amsidh.mvc.service;

import com.amsidh.mvc.model.AccountModel;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

public interface AccountService {
    @Cacheable(cacheNames = "accountCache", key = "#result.accountId")
    AccountModel saveAccount(AccountModel accountModel);

    @Cacheable(cacheNames = "accountCache", key = "#accountId")
    AccountModel getAccountById(Long accountId);

    @CachePut(cacheNames = "accountCache", key = "#result.accountId")
    AccountModel updateAccount(Long accountId, AccountModel accountModel);

    @CacheEvict(cacheNames = "accountCache", key = "#accountId")
    void deleteAccount(Long accountId);

    List<AccountModel> getAccounts();

}
