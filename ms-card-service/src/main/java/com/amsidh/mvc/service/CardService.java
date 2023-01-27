package com.amsidh.mvc.service;

import com.amsidh.mvc.model.CardModel;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

public interface CardService {
    @Cacheable(cacheNames = "cardCache", key = "#result.cardId")
    CardModel saveCard(CardModel cardModel);

    @Cacheable(cacheNames = "cardCache", key = "#cardId")
    CardModel getCardByCardId(Long cardId);

    @CachePut(cacheNames = "cardCache", key = "#result.cardId")
    CardModel updateCard(Long cardId, CardModel cardModel);

    @CacheEvict(cacheNames = "cardCache", key = "#cardId")
    void deleteCardByCardId(Long cardId);

    List<CardModel> getAllCards();
}
