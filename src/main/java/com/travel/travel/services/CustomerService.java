package com.travel.travel.services;

import com.travel.travel.entity.Customer;
import com.travel.travel.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.ws.ServiceMode;
import java.util.List;
import java.util.Optional;

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

    public Optional<Customer> getCustomer(long id){
        return customerRepository.findById(id);
    }

    public void deleteCustomer(Customer customer){
        customerRepository.delete(customer);
    }

}
