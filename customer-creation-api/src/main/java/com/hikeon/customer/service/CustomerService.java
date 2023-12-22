package com.hikeon.customer.service;

import com.hikeon.customer.model.CustomerDTO;

import java.util.Optional;

public interface CustomerService {
    public Optional<CustomerDTO> createCustomer(CustomerDTO customerDTO);
}
