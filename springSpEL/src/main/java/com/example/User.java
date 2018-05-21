package com.example;

import java.util.List;
import java.util.Map;

public class User {

    private int id;
    private String username;

    private int[] interestsArray;
    private List interestsList;
    private Map interestsMap;

    public Boolean isVipMember(String username){
        return true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int[] getInterestsArray() {
        return interestsArray;
    }

    public void setInterestsArray(int[] interestsArray) {
        this.interestsArray = interestsArray;
    }

    public List getInterestsList() {
        return interestsList;
    }

    public void setInterestsList(List interestsList) {
        this.interestsList = interestsList;
    }

    public Map getInterestsMap() {
        return interestsMap;
    }

    public void setInterestsMap(Map interestsMap) {
        this.interestsMap = interestsMap;
    }
}
