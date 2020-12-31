package com.esprit.barterexchange.Entities;

import java.sql.Date;

public class SignalUser {

    int id, userId;
    Date date;
    String description;
    boolean treated;

    public SignalUser(){

    }

    public SignalUser(int id, int userId, Date date, String description, boolean treated) {
        this.id = id;
        this.userId = userId;
        this.date = date;
        this.description = description;
        this.treated = treated;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isTreated() {
        return treated;
    }

    public void setTreated(boolean treated) {
        this.treated = treated;
    }

    @Override
    public String toString() {
        return "SignalUser{" +
                "id=" + id +
                ", userId=" + userId +
                ", date=" + date +
                ", description='" + description + '\'' +
                ", treated=" + treated +
                '}';
    }
}
