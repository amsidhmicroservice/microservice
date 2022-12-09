package com.amsidh.mvc.controller;

import com.amsidh.mvc.client.feign.CardServiceFeignClient;
import com.amsidh.mvc.model.AccountModel;
import com.amsidh.mvc.model.CardModel;
import com.amsidh.mvc.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping("/accounts")
public class AccountController {

    private final AccountService accountService;
    private final CardServiceFeignClient cardServiceFeignClient;

    @GetMapping
    public List<AccountModel> getAllAccounts() {
        return accountService.getAccounts();
    }

    @GetMapping("{accountId}")
    public AccountModel getAccountByAccountId(@PathVariable("accountId") Long accountId) {
       log.info("Request received for getAccountByAccountId with accountId {}", accountId);
        AccountModel accountModel = accountService.getAccountById(accountId);
        CardModel cardModel = cardServiceFeignClient.getCardByCardId(1L);
        accountModel.setCardModel(cardModel);
        return accountModel;
    }

    @PostMapping
    public AccountModel createAccount(@RequestBody @Validated AccountModel accountModel) {
        return accountService.saveAccount(accountModel);
    }

    @PutMapping("{accountId}")
    public AccountModel updateAccount(@PathVariable("accountId") Long accountId, @RequestBody @Validated AccountModel accountModel) {
        return accountService.updateAccount(accountId, accountModel);
    }

    @DeleteMapping("{accountId}")
    public ResponseEntity<String> deleteAccount(@PathVariable("accountId") Long accountId) {
        accountService.deleteAccount(accountId);
        return ResponseEntity.ok(String.format("Account with accountId %d deleted successfully",accountId));
    }

}
