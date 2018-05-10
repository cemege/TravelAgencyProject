package com.travel.travel.controller;


import com.travel.travel.entity.Hotel;
import com.travel.travel.entity.Reserve;
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

}
