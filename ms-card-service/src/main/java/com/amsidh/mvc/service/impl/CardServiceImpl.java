package com.amsidh.mvc.service.impl;

import com.amsidh.mvc.entity.Card;
import com.amsidh.mvc.exception.CardNotFoundException;
import com.amsidh.mvc.model.CardModel;
import com.amsidh.mvc.repository.CardRepository;
import com.amsidh.mvc.service.CardService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Slf4j
@Service
public class CardServiceImpl implements CardService {
    private final CardRepository cardRepository;
    private final ObjectMapper objectMapper;

    @Cacheable(value = "ms-card-cache", key = "#result.cardId")
    @Override
    public CardModel saveCard(CardModel cardModel) {
        Card card = objectMapper.convertValue(cardModel, Card.class);
        Card savedCard = cardRepository.saveAndFlush(card);
        return objectMapper.convertValue(savedCard, CardModel.class);
    }

    @Cacheable(value = "ms-card-cache", key = "#cardId")
    @Override
    public CardModel getCardByCardId(Long cardId) {
        Card card = cardRepository.findById(cardId).orElseThrow(() -> new CardNotFoundException(String.format("Card with cardId %d not found", cardId)));
        return objectMapper.convertValue(card, CardModel.class);
    }

    @CachePut(value = "ms-card-cache", key = "#result.cardId")
    @Override
    public CardModel updateCard(Long cardId, CardModel cardModel) {
        CardModel existingCardModel = getCardByCardId(cardId);
        Optional.ofNullable(cardModel.getCardType()).ifPresent(existingCardModel::setCardType);
        Optional.ofNullable(cardModel.getCardNumber()).ifPresent(existingCardModel::setCardNumber);
        return saveCard(existingCardModel);
    }

    @CacheEvict(value = "ms-card-cache", key = "#cardId")
    @Override
    public void deleteCardByCardId(Long cardId) {
        cardRepository.deleteById(cardId);
    }

    @Override
    public List<CardModel> getAllCards() {
        return objectMapper.convertValue(cardRepository.findAll(), new TypeReference<>() {
        });
    }
}
