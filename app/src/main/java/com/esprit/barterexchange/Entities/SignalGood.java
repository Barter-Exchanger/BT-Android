package com.esprit.barterexchange.Entities;

import java.sql.Date;

public class SignalGood {
    int id, goodId;
    Date date;

    public SignalGood(){

    }

    public SignalGood(int id, int goodId, Date date) {
        this.id = id;
        this.goodId = goodId;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGoodId() {
        return goodId;
    }

    public void setGoodId(int goodId) {
        this.goodId = goodId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "SignalGood{" +
                "id=" + id +
                ", goodId=" + goodId +
                ", date=" + date +
                '}';
    }
}
