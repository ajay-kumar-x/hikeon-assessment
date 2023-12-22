package com.hikeon.customer.controller;


import com.hikeon.customer.exception.EmailAlreadyExistsException;
import com.hikeon.customer.exception.InvalidAgeException;
import com.hikeon.customer.model.CustomerDTO;
import com.hikeon.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController()
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;
    @PostMapping("/create")
    public String createCustomer(@RequestBody CustomerDTO customerDTO)  {
        Optional<CustomerDTO> createdCustomer=customerService.createCustomer(customerDTO);
        return createdCustomer.isEmpty() ?"Invalid Customer Details":createdCustomer.get().toString();
    }

}

