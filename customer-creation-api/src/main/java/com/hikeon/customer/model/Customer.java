package com.hikeon.customer.model;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "CustomerDetails", uniqueConstraints = @UniqueConstraint(columnNames = {"occupation", "dob", "customer_group"}))
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "email",unique = true,nullable = false)
    private String email;

    @Column(name = "dob",nullable = false)
    private LocalDate dob;

    @Enumerated(EnumType.STRING)
    @Column(name = "occupation",nullable = false)
    private CustomerOccupation occupation;

    @Enumerated(EnumType.STRING)
    @Column(name = "customer_group")
    private CustomerGroup customerGroup;

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

    public CustomerGroup getCustomerGroup() {
        return customerGroup;
    }

    public void setCustomerGroup(CustomerGroup customerGroup) {
        this.customerGroup = customerGroup;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", dob='" + dob + '\'' +
                ", occupation='" + occupation + '\'' +
                ", customerGroup='" + customerGroup + '\'' +
                '}';
    }
}
