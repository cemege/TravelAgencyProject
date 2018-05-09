package com.travel.travel.controller;

import com.travel.travel.services.HotelServices;
import com.travel.travel.viewmodel.HotelDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalTime;

@RequestMapping("/hotels")
@Controller
public class HotelController {

    @Autowired
    private HotelServices hotelServices;


    @GetMapping
    public String index(Model model) {
        model.addAttribute("hotels", hotelServices.getAllHotels());
        return "hotels/index";
    }



    @GetMapping("/new")
    public String newPage(Model model){
        model.addAttribute("hotel",new HotelDto());
        return "hotels/create";
    }



    // POST /users         	- creates a new user
    @PostMapping
    public String saveIt(@Valid @ModelAttribute HotelDto hotelDto, Model model) {
        hotelServices.saveHotel(hotelDto);
        return "redirect:/hotels/";
    }

}
