package com.timeline.model;

public class CandidateDetails {


    private String city;
    private String country;

    protected CandidateDetails(){}


    public CandidateDetails(String city, String country) {
        this.city = city;
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }
}
