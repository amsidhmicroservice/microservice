package com.amsidh.mvc.client.feign;

import com.amsidh.mvc.config.FeignClientConfig;
import com.amsidh.mvc.model.CardModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "card-service", configuration = FeignClientConfig.class)
public interface CardServiceFeignClient {
    @GetMapping(path = "/cards/{cardId}")
    CardModel getCardByCardId(@PathVariable("cardId") Long cardId);
}
