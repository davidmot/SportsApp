package com.example.davidmoz.sportsapp;

/**
 * Created by davidmoz on 04.12.17.
 */

public class User {
    public String userFirstName, userLastname, userEmail, userSport, userCity, userState, userTime;


    public User() {
    }

    public User(String userFirstName, String userLastname, String userEmail, String userSport, String userCity, String userState, String userTime) {
        this.userFirstName = userFirstName;
        this.userLastname = userLastname;
        this.userEmail = userEmail;
        this.userSport = userSport;
        this.userCity = userCity;
        this.userState = userState;
        this.userTime = userTime;
    }
}
