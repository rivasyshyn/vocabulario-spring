package com.irm.vocabulario.domain.a;

import java.util.Date;

public class FlightLeg {

    private Airport departFrom;
    private Date departOn;
    private Airport arriveAt;
    private Date arriveOn;

    public FlightLeg(Airport departFrom, Date departOn, Airport arriveAt, Date arriveOn) {
        this.departFrom = departFrom;
        this.departOn = departOn;
        this.arriveAt = arriveAt;
        this.arriveOn = arriveOn;
    }

    public Airport getDepartFrom() {
        return departFrom;
    }

    public void setDepartFrom(Airport departFrom) {
        this.departFrom = departFrom;
    }

    public Date getDepartOn() {
        return departOn;
    }

    public void setDepartOn(Date departOn) {
        this.departOn = departOn;
    }

    public Airport getArriveAt() {
        return arriveAt;
    }

    public void setArriveAt(Airport arriveAt) {
        this.arriveAt = arriveAt;
    }

    public Date getArriveOn() {
        return arriveOn;
    }

    public void setArriveOn(Date arriveOn) {
        this.arriveOn = arriveOn;
    }

}
