package com.travel.travel.services;

import com.travel.travel.entity.Customer;
import com.travel.travel.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.ws.ServiceMode;
import java.util.List;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public Iterable<Customer> getAllCustomers() {

        return customerRepository.findAll();
    }

    public void saveCustomer(Customer customer) {

        customerRepository.save(customer);
    }

}
