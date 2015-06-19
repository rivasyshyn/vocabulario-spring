package com.irm.vocabulario.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.irm.vocabulario.domain.Card;
import com.irm.vocabulario.domain.CardSearchOptions;

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
    public void delete(Integer id) {
        jdbcTemplate.update("DELETE FROM cards WHERE cards.id=?", id);
    }

    @Override
    public void update(Card card) {
        jdbcTemplate.update("UPDATE cards set word=?, translation=? WHERE id=?", card.getWord(),
                card.getTranslation(), card.getId());
    }

    @Override
    public List<Card> search(String query, CardSearchOptions options) {
        List<Card> cards_w = null;
        if (options == CardSearchOptions.WORD || options == CardSearchOptions.ALL)
            cards_w = jdbcTemplate.query("search_word(?)", new String[] { query }, rowMapper);
        List<Card> cards_t = null;
        if (options == CardSearchOptions.TRANSLATION || options == CardSearchOptions.ALL)
            cards_t = jdbcTemplate
                    .query("search_translation(?)", new String[] { query }, rowMapper);

        List<Card> result = new ArrayList<Card>();
        result.addAll(cards_w);
        result.addAll(cards_t);
        return result;
    }

}
