package com.irm.vocabulario.dao;

import java.util.List;

import com.irm.vocabulario.domain.Card;

public interface CardsDao {

    public enum SearchOptions {
        WORD, TRANSLATION, ALL
    }

    List<Card> getAll();

    Card add(Card card);

    void delete(Card card);

    void update(Card card);

    List<Card> search(String query, SearchOptions options);

}
