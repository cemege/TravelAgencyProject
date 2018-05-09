package com.travel.travel.controller;

import com.travel.travel.entity.Customer;
import com.travel.travel.entity.Hotel;
import com.travel.travel.repository.HotelRepo;
import com.travel.travel.services.HotelServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;

@RequestMapping("/hotels")
@Controller
public class HotelController {

    @Autowired
    private HotelRepo hotelRepo;


    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model){
        model.addAttribute("hotels", hotelRepo.findAll());
        return "hotels/index";
    }




    // POST /users         	- creates a new user
    @RequestMapping(method=RequestMethod.POST)
    public String saveIt(@ModelAttribute Hotel hotel, Model model)
    {
        try{

            hotelRepo.save(hotel);

            return "redirect:/hotels/";

        }
        catch(Exception e){
            return "error";
        }
    }

}
