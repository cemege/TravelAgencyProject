package com.travel.travel.services;

import com.travel.travel.entity.Hotel;
import com.travel.travel.repository.HotelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServices {

    @Autowired
    private HotelRepo hotelRepo;

    public List<Hotel> getAllHotels() {
        return hotelRepo.findAll();
    }

    public void saveHotel(Hotel hotel) {
        hotelRepo.save(hotel);

    }


}
