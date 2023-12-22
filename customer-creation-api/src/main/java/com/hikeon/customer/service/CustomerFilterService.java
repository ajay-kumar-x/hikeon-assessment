package com.hikeon.customer.service;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

@Service
public class CustomerFilterService {
    public boolean isValidAge(LocalDate dob){
        LocalDate currentDate = LocalDate.now();
        Period period = Period.between(dob, currentDate);
        return period.getYears() >= 18;
    }

}
