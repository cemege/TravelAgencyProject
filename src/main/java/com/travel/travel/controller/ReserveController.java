package com.travel.travel.controller;


import com.travel.travel.entity.Customer;
import com.travel.travel.entity.Hotel;
import com.travel.travel.entity.Reserve;
import com.travel.travel.services.CustomerService;
import com.travel.travel.services.HotelServices;
import com.travel.travel.services.ReserveService;
import com.travel.travel.viewmodel.HotelDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RequestMapping("/reserves")
@Controller
public class ReserveController {

    @Autowired
    ReserveService reserveService;

    @Autowired
    CustomerService customerService;

    @Autowired
    HotelServices hotelServices;

    @RequestMapping(method=RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("reserves", reserveService.getAllRevers());
        return "reserves/index";
    }

    @GetMapping("/new")
    public String newPage(Model model){
        model.addAttribute("reserve",new Reserve());
        return "reserves/create";
    }

    // POST /users         	- creates a new user
    @PostMapping
    public String saveIt(@Valid @ModelAttribute Reserve reserve, Model model) {

        if(checkCustomerAndHotelID(reserve,reserve.getReservationAuthor().getId(),reserve.getHotel().getId()))
            reserveService.saveService(reserve);
        return "redirect:/reserves/";
    }

    // GET  /users/{id}/remove 	- removes the user with identifier {id}
    @RequestMapping(value="{id}/remove", method=RequestMethod.GET)
    public String remove(@PathVariable("id") long id, Model model) {
        Optional<Reserve> reserve = reserveService.findById(id);
        reserveService.deleteReserve(reserve.get());
        model.addAttribute("reserves", reserveService.getAllRevers());
        return "reserves/index";
    }

    private boolean checkCustomerAndHotelID(Reserve reserve,long customerID,long hotelID){
        hotelID = reserve.getHotel().getId();
        customerID = reserve.getReservationAuthor().getId();

        customerService.getCustomer(customerID).ifPresent(reserve::setReservationAuthor);
        hotelServices.findById(hotelID).ifPresent(reserve::setHotel);

        if(reserve.getHotel() !=null && reserve.getReservationAuthor() != null)
            return true;
        else
            return false;
    }

}
