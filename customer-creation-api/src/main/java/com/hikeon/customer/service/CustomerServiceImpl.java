package com.hikeon.customer.service;

import com.hikeon.customer.exception.EmailAlreadyExistsException;
import com.hikeon.customer.exception.InvalidAgeException;
import com.hikeon.customer.model.Customer;
import com.hikeon.customer.model.CustomerDTO;
import com.hikeon.customer.model.CustomerGroup;
import com.hikeon.customer.model.CustomerOccupation;
import com.hikeon.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    CustomerFilterService customerFilterService;
    @Override
    public Optional<CustomerDTO> createCustomer(CustomerDTO customerDTO){

        try {
            if (customerRepository.existsByEmail(customerDTO.getEmail()))
                throw new EmailAlreadyExistsException("! Email already Exists !");
            if (!customerFilterService.isValidAge(customerDTO.getDob()))
                throw new InvalidAgeException("! Age should be above 18 Year");

        CustomerGroup customerGroup;
        if (customerDTO.getEmail().endsWith("@hikeon.tech")) customerGroup = CustomerGroup.HIKEON;
        else {
            if (customerDTO.getOccupation() == CustomerOccupation.DEVELOPER) customerGroup = CustomerGroup.DEVELOPER;
            else if (customerDTO.getOccupation() == CustomerOccupation.CHEF) customerGroup = CustomerGroup.CHEF;
            else customerGroup = CustomerGroup.NA;
        }

        Customer customer = customerDtoToCustomer(customerDTO);
        customer.setCustomerGroup(customerGroup);
        CustomerDTO createdCustomer = customerToCustomerDTO(customerRepository.save(customer));
        return Optional.of(createdCustomer);
        }
        catch (EmailAlreadyExistsException e){
            System.err.println(e.getMessage());
        }catch (InvalidAgeException e){
            System.err.println(e.getMessage());
        }
        return Optional.empty();
    }



    private Customer customerDtoToCustomer(CustomerDTO customerDTO){
        Customer customer=new Customer();
        customer.setName(customerDTO.getName());
        customer.setEmail(customerDTO.getEmail());
        customer.setDob(customerDTO.getDob());
        customer.setOccupation(customerDTO.getOccupation());
        return customer;
    }
    private CustomerDTO customerToCustomerDTO(Customer customer){
        CustomerDTO customerDTO=new CustomerDTO();
        customerDTO.setId(customer.getId());
        customerDTO.setName(customer.getName());
        customerDTO.setEmail(customer.getEmail());
        customerDTO.setDob(customer.getDob());
        customerDTO.setOccupation(customer.getOccupation());
        customerDTO.setCustomerGroup(customer.getCustomerGroup());
        return customerDTO;
    }
}
