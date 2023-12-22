package com.hikeon.customer.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.hikeon.customer.model.Customer;
import com.hikeon.customer.model.CustomerDTO;
import com.hikeon.customer.model.CustomerGroup;
import com.hikeon.customer.model.CustomerOccupation;
import com.hikeon.customer.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Optional;


public class CustomerServiceImplTest {

    @InjectMocks
    private CustomerServiceImpl customerService;

    @Mock
    private CustomerRepository customerRepository;

    @Mock
    private CustomerFilterService customerFilterService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateCustomer_Success() {
        CustomerDTO customerDTO = new CustomerDTO(1,"Ajay","ajaykr1729@gmail.com",LocalDate.of(1998,9,5), CustomerOccupation.DEVELOPER, CustomerGroup.DEVELOPER);

        when(customerRepository.existsByEmail(anyString())).thenReturn(false);
        when(customerFilterService.isValidAge(any())).thenReturn(true);
        when(customerRepository.save(any())).thenReturn(new Customer());

        Optional<CustomerDTO> result = customerService.createCustomer(customerDTO);

        assertTrue(result.isPresent());
    }

    @Test
    public void testCreateCustomer_EmailAlreadyExists() {
        CustomerDTO customerDTO = new CustomerDTO(1,"Ajay","ajaykr1729@gmail.com",LocalDate.of(1998,9,5), CustomerOccupation.DEVELOPER, CustomerGroup.DEVELOPER);

        when(customerRepository.existsByEmail(anyString())).thenReturn(true);

        Optional<CustomerDTO> result = customerService.createCustomer(customerDTO);

        assertFalse(result.isPresent());
    }

    @Test
    public void testCreateCustomer_InvalidAge() {
        CustomerDTO customerDTO = new CustomerDTO(1,"Ajay","ajaykr1729@gmail.com",LocalDate.of(1998,9,5), CustomerOccupation.DEVELOPER, CustomerGroup.DEVELOPER);

        when(customerRepository.existsByEmail(anyString())).thenReturn(false);
        when(customerFilterService.isValidAge(any())).thenReturn(false);

        Optional<CustomerDTO> result = customerService.createCustomer(customerDTO);

        assertFalse(result.isPresent());

    }
}
