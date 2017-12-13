package com.example.davidmoz.sportsapp;

import com.google.firebase.database.Exclude;

import java.util.HashMap;
import java.util.Map;

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

    public String getUserEmail() {
        return this.userEmail;
    }

    public void setUserSport(String userSport) {
        this.userSport = userSport;
    }

    public void setUserCity(String userCity) {
        this.userCity = userCity;
    }

    public void setUserState(String userState) {
        this.userState = userState;
    }

    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("userFirstName:", userFirstName);
        result.put("userLastname:", userLastname);
        result.put("userDay:", userDay);
        result.put("userEmail:", userEmail);
        result.put("userSport:", userSport);
        result.put("userStartTime:", userStartTime);
        result.put("userEndTime:", userEndTime);
        result.put("userCity:", userCity);
        result.put("userState:", userState);

        return result;
    }

}
