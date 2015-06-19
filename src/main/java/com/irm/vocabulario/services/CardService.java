package com.irm.vocabulario.services;

import java.util.List;

import com.irm.vocabulario.domain.Card;
import com.irm.vocabulario.domain.CardSearchOptions;

public interface CardService {

    List<Card> getCards();
    
    void addCard(Card card);
    
    void updateCard(Card card);
    
    void deleteCard(Integer id);
    
    void searchCards(String query, CardSearchOptions options);
    
}
