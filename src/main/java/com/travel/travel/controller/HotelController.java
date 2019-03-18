package com.travel.travel.controller;

import com.travel.travel.entity.Customer;
import com.travel.travel.entity.Hotel;
import com.travel.travel.services.HotelServices;
import com.travel.travel.viewmodel.HotelDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalTime;
import java.util.Optional;

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
    public String saveIt(@Valid @ModelAttribute HotelDto hotelDto, BindingResult bindingResult, Model model) {
        System.out.println("Hotels save controller called.");
        hotelServices.saveHotel(hotelDto);
        return "redirect:/hotels/";
    }

    // GET  /users/{id}/remove 	- removes the user with identifier {id}
    @RequestMapping(value="{id}/remove", method=RequestMethod.GET)
    public String remove(@PathVariable("id") long id, Model model) {
        Optional<Hotel> customer = hotelServices.findById(id);
        hotelServices.delete(customer.get());
        model.addAttribute("hotels", hotelServices.getAllHotels());
        return "redirect:/hotels";
    }

}
