package com.travel.travel.entity;


import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Reserve extends BaseEntity {

    @OneToOne(cascade = {CascadeType.ALL})
    @ManyToOne
    private Hotel hotel;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customerid")
    private Customer reservationAuthor;

    private LocalDateTime checkIn;
    private LocalDateTime checkOut;
    private String paymentType;


    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Customer getReservationAuthor() {
        return reservationAuthor;
    }

    public void setReservationAuthor(Customer reservationAuthor) {
        this.reservationAuthor = reservationAuthor;
    }

    public LocalDateTime getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(LocalDateTime checkIn) {
        this.checkIn = checkIn;
    }

    public LocalDateTime getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(LocalDateTime checkOut) {
        this.checkOut = checkOut;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }
}
