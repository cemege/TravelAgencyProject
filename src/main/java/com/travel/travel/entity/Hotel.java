package com.travel.travel.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import java.sql.Date;
import java.sql.Time;

@Entity
public class Hotel extends BaseEntity {

    private Long managerId;
    private String name;
    private String location;
    private String phoneNumber;
    private int numberOfRooms;
    private int ratingScore;

    private Time avaliableTime;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getManagerId() {
        return managerId;
    }

    public void setManagerId(Long managerId) {
        this.managerId = managerId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public int getRatingScore() {
        return ratingScore;
    }

    public void setRatingScore(int ratingScore) {
        this.ratingScore = ratingScore;
    }

    public Time getAvaliableTime() {
        return avaliableTime;
    }

    public void setAvaliableTime(Time avaliableTime) {
        this.avaliableTime = avaliableTime;
    }
}
