package com.irm.vocabulario.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.irm.vocabulario.domain.Card;

public class CardRowMapper implements RowMapper<Card> {

    @Override
    public Card mapRow(ResultSet arg0, int arg1) throws SQLException {
        Card card = new Card();
        card.setId(arg0.getInt("id"));
        card.setWord(arg0.getString("word"));
        card.setTranslation(arg0.getString("translation"));
        return card;
    }

}
