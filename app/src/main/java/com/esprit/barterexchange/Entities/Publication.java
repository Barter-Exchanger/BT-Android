package com.esprit.barterexchange.Entities;

import com.google.gson.annotations.SerializedName;

public class Publication {
    String username;
    @SerializedName("label")
    String goodLabel;
    @SerializedName("description")
    String goodDescription;
    String location;
    int goodId;

    public Publication(String username, String goodLabel, String goodDescription, int goodId) {
        this.username = username;
        this.goodLabel = goodLabel;
        this.goodDescription = goodDescription;
        this.goodId = goodId;
    }

    public Publication() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGoodLabel() {
        return goodLabel;
    }

    public void setGoodLabel(String goodLabel) {
        this.goodLabel = goodLabel;
    }

    public String getGoodDescription() {
        return goodDescription;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setGoodDescription(String goodDescription) {
        this.goodDescription = goodDescription;
    }

    public int getGoodId() {
        return goodId;
    }

    public void setGoodId(int goodId) {
        this.goodId = goodId;
    }

    @Override
    public String toString() {
        return "Publication{" +
                "username='" + username + '\'' +
                ", goodLabel='" + goodLabel + '\'' +
                ", goodDescription='" + goodDescription + '\'' +
                '}';
    }
}
