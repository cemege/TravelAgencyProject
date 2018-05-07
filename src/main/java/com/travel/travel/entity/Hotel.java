package com.travel.travel.entity;

import javax.persistence.Entity;
import java.time.LocalTime;

@Entity
public class Hotel extends BaseEntity {

    private Long managerId;
    private String location;
    private String phoneNumber;
    private int numberOfRooms;
    private int ratingScore;
    private LocalTime avaliableTime;


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

    public LocalTime getAvaliableTime() {
        return avaliableTime;
    }

    public void setAvaliableTime(LocalTime avaliableTime) {
        this.avaliableTime = avaliableTime;
    }
}
