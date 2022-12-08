package com.amsidh.mvc.controller;

import com.amsidh.mvc.model.CardModel;
import com.amsidh.mvc.service.CardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping("/cards")
public class CardController {

    private final CardService cardService;

    @GetMapping
    public List<CardModel> getAllCards() {
        return cardService.getAllCards();
    }

    @GetMapping("/{cardId}")
    public CardModel getCardByCardId(@PathVariable("cardId") Long cardId) {
        return cardService.getCardByCardId(cardId);
    }

    @PostMapping
    public CardModel saveCard(@RequestBody @Validated CardModel cardModel) {
        return cardService.saveCard(cardModel);
    }

    @PutMapping("/{cardId}")
    public CardModel updateCard(@PathVariable("cardId") Long cardId, @RequestBody @Validated CardModel cardModel) {
        return cardService.updateCard(cardId, cardModel);
    }

    @DeleteMapping("/{cardId}")
    public ResponseEntity<String> deleteByCardId(@PathVariable("cardId") Long cardId) {
        cardService.deleteCardByCardId(cardId);
        return ResponseEntity.ok(String.format("Card with cardId %d deleted successfully", cardId));
    }

}
