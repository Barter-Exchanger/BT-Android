package com.esprit.barterexchange.Entities;

import java.sql.Date;

public class Exchange {

    int id;
    Date date;
    int user1, user2;
    int goodUser1, goodUser2;
    int user1Confirmation, user2Confirmation;

    public Exchange(){

    }

    public Exchange(int id, Date date, int user1, int user2, int goodUser1, int goodUser2, int user1Confirmation, int user2Confirmation) {
        this.id = id;
        this.date = date;
        this.user1 = user1;
        this.user2 = user2;
        this.goodUser1 = goodUser1;
        this.goodUser2 = goodUser2;
        this.user1Confirmation = user1Confirmation;
        this.user2Confirmation = user2Confirmation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getUser1() {
        return user1;
    }

    public void setUser1(int user1) {
        this.user1 = user1;
    }

    public int getUser2() {
        return user2;
    }

    public void setUser2(int user2) {
        this.user2 = user2;
    }

    public int getGoodUser1() {
        return goodUser1;
    }

    public void setGoodUser1(int goodUser1) {
        this.goodUser1 = goodUser1;
    }

    public int getGoodUser2() {
        return goodUser2;
    }

    public void setGoodUser2(int goodUser2) {
        this.goodUser2 = goodUser2;
    }

    public int getUser1Confirmation() {
        return user1Confirmation;
    }

    public void setUser1Confirmation(int user1Confirmation) {
        this.user1Confirmation = user1Confirmation;
    }

    public int getUser2Confirmation() {
        return user2Confirmation;
    }

    public void setUser2Confirmation(int user2Confirmation) {
        this.user2Confirmation = user2Confirmation;
    }

    @Override
    public String toString() {
        return "Exchange{" +
                "id=" + id +
                ", date=" + date +
                ", user1=" + user1 +
                ", user2=" + user2 +
                ", goodUser1=" + goodUser1 +
                ", goodUser2=" + goodUser2 +
                ", user1Confirmation=" + user1Confirmation +
                ", user2Confirmation=" + user2Confirmation +
                '}';
    }
}
