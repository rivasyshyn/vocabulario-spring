package com.irm.vocabulario.dao;

import java.util.List;

import com.irm.vocabulario.domain.Card;
import com.irm.vocabulario.domain.CardSearchOptions;

public interface CardsDao {

    List<Card> getAll();

    Card add(Card card);

    void delete(Integer id);

    void update(Card card);

    List<Card> search(String query, CardSearchOptions options);

}
