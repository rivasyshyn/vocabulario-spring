package com.irm.vocabulario.controllers;

import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.irm.vocabulario.dao.CardsDao;
import com.irm.vocabulario.domain.Card;

@Controller
public class MainController {

    private CardsDao cardDao;

    @Autowired
    @Qualifier("cardDao")
    public void setCardDao(CardsDao cardDao) {
        this.cardDao = cardDao;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model, Locale locale) {
        List<Card> cards = cardDao.getAll();
        model.addAttribute("cards", cards);
        model.addAttribute("newCard", new Card());
        model.addAttribute(locale);
        return "index";
    }

    @RequestMapping(value = "addCard", method = RequestMethod.POST)
    public String addCard(@Valid @ModelAttribute("newCard") Card card, BindingResult result,
            ModelMap model, Locale locale) {
        if (!result.hasErrors()) {
            if (card.getId() != null) {
                cardDao.update(card);
            } else {
                cardDao.add(card);
            }
            return index((Model) model, locale);
        } else {
            List<Card> cards = cardDao.getAll();
            model.addAttribute("cards", cards);
            return "index";
        }
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") Integer id, Model model, Locale locale) {
        Card card = new Card();
        card.setId(id);
        cardDao.delete(card);
        return index(model, locale);
    }

    @RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable("id") Integer id, Model model) {
        List<Card> cards = cardDao.getAll();
        Card card = new Card();
        for (Card c : cards) {
            if (c.getId() == id)
                card = c;
        }
        model.addAttribute("cards", cards);
        model.addAttribute("newCard", card);
        return "index";
    }

}
