package com.travel.travel.viewmodel;

import com.travel.travel.config.Constants;
import com.travel.travel.entity.Hotel;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class HotelDto {

    private Long id;
    private Long managerId;

    private String name;
    private String location;
    private String phoneNumber;
    private Integer numberOfRooms;
    private Integer ratingScore;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime availableTime;


    public HotelDto(Hotel hotel) {

        this.id = hotel.getId();
        this.managerId = hotel.getManagerId();
        this.name = hotel.getName();
        this.location = hotel.getLocation();
        this.phoneNumber = hotel.getPhoneNumber();
        this.numberOfRooms = hotel.getNumberOfRooms();
        this.ratingScore = hotel.getRatingScore();
        this.availableTime = hotel.getAvaliableTime();

    }

    public HotelDto() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getManagerId() {
        return managerId;
    }

    public void setManagerId(Long managerId) {
        this.managerId = managerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Integer getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(Integer numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public Integer getRatingScore() {
        return ratingScore;
    }

    public void setRatingScore(Integer ratingScore) {
        this.ratingScore = ratingScore;
    }

    public LocalDateTime getAvailableTime() {
        return availableTime;
    }

    public void setAvailableTime(LocalDateTime avaliableTime) {
        this.availableTime = avaliableTime;
    }

    public String toString(){
        return this.name + " " + this.phoneNumber;
    }
}
