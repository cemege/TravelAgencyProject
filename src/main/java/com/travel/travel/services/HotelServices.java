package com.travel.travel.services;

import com.travel.travel.entity.Hotel;
import com.travel.travel.repository.HotelRepo;
import com.travel.travel.viewmodel.HotelDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class HotelServices {

    @Autowired
    private HotelRepo hotelRepo;

    public List<HotelDto> getAllHotels() {

        return hotelRepo.findAll()
                .stream()
                .map(HotelDto::new)
                .collect(Collectors.toList());

    }

    public Hotel saveHotel(HotelDto hotelDto) {
        System.out.println(hotelDto.toString() + " Hotel save service called.");

        Hotel hotel = new Hotel();
        hotel.setName(hotelDto.getName());
        hotel.setRatingScore(hotelDto.getRatingScore());
        hotel.setPhoneNumber(hotelDto.getPhoneNumber());
        hotel.setLocation(hotelDto.getLocation());
        hotel.setNumberOfRooms(hotelDto.getNumberOfRooms());
        hotel.setManagerId(hotelDto.getManagerId());

        System.out.println(hotelDto.getAvailableTime());

        Date available =  Date.valueOf(hotelDto.getAvailableTime());

        Time test = Time.valueOf("15:12:21");

        hotel.setAvaliableTime(test);


        System.out.println(available.toLocalDate());

        return hotelRepo.save(hotel);

    }


    public Optional<Hotel> findById(long id) {
        return hotelRepo.findById(id);
    }

    public void delete(Hotel hotel) {
        hotelRepo.delete(hotel);
    }
}
