package com.amsidh.mvc.service;

import com.amsidh.mvc.model.CardModel;

import java.util.List;

public interface CardService {
    CardModel saveCard(CardModel cardModel);

    CardModel getCardByCardId(Long cardId);

    CardModel updateCard(Long cardId, CardModel cardModel);

    void deleteCardByCardId(Long cardId);

    List<CardModel> getAllCards();
}
