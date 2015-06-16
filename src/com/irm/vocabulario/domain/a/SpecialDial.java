package com.irm.vocabulario.domain.a;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.util.Assert;

public class SpecialDial {

    private Airport ariveAt;
    private Airport departFrom;
    private BigDecimal cost;
    private Date beginOn;
    private Date endOn;

    public SpecialDial(Airport ariveAt, Airport departFrom, BigDecimal cost, Date beginOn,
            Date endOn) {
        this.ariveAt = ariveAt;
        this.departFrom = departFrom;
        this.cost = cost;
        this.beginOn = beginOn;
        this.endOn = endOn;
    }

    public Airport getAriveAt() {
        return ariveAt;
    }

    public Airport getDepartFrom() {
        return departFrom;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public boolean isValidNow() {
        return isValidOn(new Date());
    }

    public boolean isValidOn(Date date) {
        Assert.notNull(date, "Date must not be null");
        Date dateCopy = new Date(date.getTime());
        return ((dateCopy.equals(beginOn) || dateCopy.after(beginOn)) && (dateCopy.equals(endOn) || dateCopy
                .before(endOn)));
    }

}
