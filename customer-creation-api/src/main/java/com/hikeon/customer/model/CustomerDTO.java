package com.hikeon.customer.model;


import java.time.LocalDate;

public class CustomerDTO {
    private long id;
    private String name;
    private String email;
    private LocalDate dob;
    private CustomerOccupation occupation;

    private CustomerGroup customerGroup;

    public CustomerGroup getCustomerGroup() {
        return customerGroup;
    }

    public void setCustomerGroup(CustomerGroup customerGroup) {
        this.customerGroup = customerGroup;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public CustomerOccupation getOccupation() {
        return occupation;
    }

    public void setOccupation(CustomerOccupation occupation) {
        this.occupation = occupation;
    }

    @Override
    public String toString() {
        return "CustomerDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", dob=" + dob +
                ", occupation=" + occupation +
                ", customerGroup=" + customerGroup +
                '}';
    }
}
