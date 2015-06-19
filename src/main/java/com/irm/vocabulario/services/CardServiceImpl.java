package com.irm.vocabulario.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.irm.vocabulario.dao.CardsDao;
import com.irm.vocabulario.domain.Card;
import com.irm.vocabulario.domain.CardSearchOptions;

@Service("cardService")
public class CardServiceImpl implements CardService {

    private CardsDao cardDao;
    
    @Autowired
    @Qualifier("cardDao")
    public void setCardDao(CardsDao cardDao) {
        this.cardDao = cardDao;
    }
    
    @Override
    public List<Card> getCards() {
        return cardDao.getAll();
    }

    @Override
    public void addCard(Card card) {
        cardDao.add(card);
    }

    @Override
    public void updateCard(Card card) {
        cardDao.update(card);
    }

    @Override
    public void deleteCard(Integer id) {
        cardDao.delete(id);
    }

    @Override
    public void searchCards(String query, CardSearchOptions options) {
        cardDao.search(query, options);
    }

}
