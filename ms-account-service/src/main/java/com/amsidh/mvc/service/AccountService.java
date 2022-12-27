package com.amsidh.mvc.service;

import com.amsidh.mvc.model.AccountModel;

import java.util.List;

public interface AccountService {
    AccountModel saveAccount(AccountModel accountModel);

    AccountModel getAccountById(Long accountId);

    AccountModel updateAccount(Long accountId, AccountModel accountModel);

    void deleteAccount(Long accountId);

    List<AccountModel> getAccounts();

}
