package com.example.davidmoz.sportsapp;

/**
 * Created by davidmoz on 04.12.17.
 */

public class User {
    public String userFirstName, userLastname, userEmail, userSport, userCity, userState, userStartTime, userEndTime, userDay;


    public User() {
    }

    public User(String userFirstName, String userLastname, String userEmail, String userSport, String userCity, String userState, String userStartTime, String userEndTime, String userDay) {
        this.userFirstName = userFirstName;
        this.userLastname = userLastname;
        this.userEmail = userEmail;
        this.userSport = userSport;
        this.userCity = userCity;
        this.userState = userState;
        this.userStartTime = userStartTime;
        this.userEndTime = userEndTime;
        this.userDay = userDay;
    }

    public void setUserSport (String userSport) {
        this.userSport = userSport;
    }
}
