package com.amsidh.mvc.client.feign;

import com.amsidh.mvc.config.FeignClientConfig;
import com.amsidh.mvc.model.AccountModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "account-service", configuration = FeignClientConfig.class)
public interface AccountFeignClient {

    @GetMapping("/accounts/{accountId}")
    AccountModel getAccountByAccountId(@PathVariable("accountId") Long accountId);
}
