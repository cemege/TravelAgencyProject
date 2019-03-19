package com.travel.travel.controller;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import com.travel.travel.entity.Customer;
import com.travel.travel.entity.Reserve;
import com.travel.travel.repository.CustomerRepository;
import com.travel.travel.services.CustomerService;
import com.travel.travel.services.ReserveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/customers")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @Autowired
    ReserveService reserveService;


    // GET  /users 			- the list of users

    @RequestMapping(method=RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("customers", customerService.getAllCustomers());
        return "customers/index";
    }

    // GET  /users/new			- the form to fill the data for a new user
    @RequestMapping(value="/new", method=RequestMethod.GET)
    public String newCustomer(Model model) {
        model.addAttribute("customer", new Customer());
        return "customers/create";
    }

    // POST /users         	- creates a new user
    @RequestMapping(method=RequestMethod.POST)
    public String saveIt(@ModelAttribute Customer customer, Model model)
    {
        try{


            customerService.saveCustomer(customer);

            return "redirect:/customers/";

        }
        catch(Exception e){
            return "error";
        }
    }


    // GET  /customers/{id} 		- the user with identifier {id}
    @RequestMapping(value="{id}", method=RequestMethod.GET)
    public String show(@PathVariable("id") Long id, Model model) {
        Optional<Customer> user = customerService.getCustomer(id);


        model.addAttribute("customer", user.get());
        model.addAttribute("reserves", reserveService.getUsersReserve(user.get().getId()));
        return "customers/show";
    }

    // GET  /users/{id}/remove 	- removes the user with identifier {id}
    @RequestMapping(value="{id}/remove", method=RequestMethod.GET)
    public String remove(@PathVariable("id") long id, Model model) {
        Optional<Customer> customer = customerService.getCustomer(id);
        customerService.deleteCustomer(customer.get());
        model.addAttribute("customers", customerService.getAllCustomers());
        return "customers/index";
    }

    // GET /users/{id}/edit - form to edit user
    @RequestMapping(value="{id}/edit", method=RequestMethod.GET)
    public String edit(@PathVariable("id") long id, Model model) {
        Optional<Customer> user = customerService.getCustomer(id);
        model.addAttribute("customer", user);
        return "customers/edit";
    }

}