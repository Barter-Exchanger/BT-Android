package com.esprit.barterexchange.Entities;

public class CurrentUser {

    public static int id;
    public static String firstName, lastName, email, password,username;

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        CurrentUser.id = id;
    }

    public static String getFirstName() {
        return firstName;
    }

    public static void setFirstName(String firstName) {
        CurrentUser.firstName = firstName;
    }

    public static String getLastName() {
        return lastName;
    }

    public static void setLastName(String lastName) {
        CurrentUser.lastName = lastName;
    }

    public static String getEmail() {
        return email;
    }

    public static void setEmail(String email) {
        CurrentUser.email = email;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        CurrentUser.password = password;
    }

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        CurrentUser.username = username;
    }

    @Override
    public String toString() {
        return "ID = "+id+" First = "+firstName+" Last = "+lastName+" user = "+username+" mail = "+email+" password = "+password;
    }

}
