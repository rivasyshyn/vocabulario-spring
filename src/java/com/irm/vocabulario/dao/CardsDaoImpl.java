package com.irm.vocabulario.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.irm.vocabulario.domain.Card;

@Repository("cardDao")
public class CardsDaoImpl implements CardsDao {

    private JdbcTemplate jdbcTemplate;
    private CardRowMapper rowMapper;

    @Autowired
    public CardsDaoImpl(@Qualifier("dataSource") DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
        rowMapper = new CardRowMapper();
    }

    @Override
    public List<Card> getAll() {
        return jdbcTemplate.query("SELECT * FROM cards", rowMapper);
    }

    @Override
    public Card add(Card card) {
        int id = jdbcTemplate.update("INSERT INTO cards(word, translation) VALUES(?, ?)",
                card.getWord(), card.getTranslation());
        card.setId(id);
        return card;
    }

    @Override
    public void delete(Card card) {
        jdbcTemplate.update("DELETE FROM cards WHERE cards.id=?", card.getId());
    }

    @Override
    public void update(Card card) {
        jdbcTemplate.update("UPDATE cards set word=?, translation=? WHERE id=?", card.getWord(),
                card.getTranslation(), card.getId());
    }

    @Override
    public List<Card> search(String query, SearchOptions options) {
        List<Card> cards_w = null;
        if (options == SearchOptions.WORD || options == SearchOptions.ALL)
            cards_w = jdbcTemplate.query("search_word(?)", new String[] { query }, rowMapper);
        List<Card> cards_t = null;
        if (options == SearchOptions.TRANSLATION || options == SearchOptions.ALL)
            cards_t = jdbcTemplate
                    .query("search_translation(?)", new String[] { query }, rowMapper);

        List<Card> result = new ArrayList<Card>();
        result.addAll(cards_w);
        result.addAll(cards_t);
        return result;
    }

}
