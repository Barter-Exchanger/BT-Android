package com.esprit.barterexchange.Entities;

public class UserExchange {

    int userId, exchangeId;

    public UserExchange(int userId, int exchangeId) {
        this.userId = userId;
        this.exchangeId = exchangeId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getExchangeId() {
        return exchangeId;
    }

    public void setExchangeId(int exchangeId) {
        this.exchangeId = exchangeId;
    }

    @Override
    public String toString() {
        return "UserExchange{" +
                "userId=" + userId +
                ", exchangeId=" + exchangeId +
                '}';
    }
}
