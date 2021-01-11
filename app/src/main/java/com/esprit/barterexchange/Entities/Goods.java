package com.esprit.barterexchange.Entities;

public class Goods {
    int id, user;
    String name, description, image, location;

    public Goods(){

    }

    public Goods(int user, String name, String description, String image, String location) {
        this.user = user;
        this.name = name;
        this.description = description;
        this.image = image;
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

   /* @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", user=" + user +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                '}';
    }*/

    @Override
    public String toString() {
        return name;
    }
}
