package com.travel.travel.controller;

import com.travel.travel.services.HomeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @Autowired
    private HomeServices homeServices;

    @GetMapping("/test/services")
    public ResponseEntity services() {
        return ResponseEntity.ok(homeServices.getAllHotels());
    }

    @GetMapping("/")
    public String mainPage(Model model) {
        model.addAttribute("name", "muhittin");
        return "index";
    }


}
