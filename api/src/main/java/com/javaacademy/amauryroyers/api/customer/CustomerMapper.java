package com.javaacademy.amauryroyers.api.customer;

import com.javaacademy.amauryroyers.domain.customer.Customer;

import javax.inject.Named;

@Named
public class CustomerMapper {

    public CustomerDTO toDTO(Customer customer){
        return CustomerDTO.customerDTO()
                .withFirstName(customer.getFirstName())
                .withLastName(customer.getLastName())
                .withEmail(customer.getEmail())
                .withAddress(customer.getAddress())
                .withPhoneNumber(customer.getPhoneNumber());
    }

    public Customer toDomain(CustomerDTO customerDTO){
        return new Customer.CustomerBuilder()
                .withFirstName(customerDTO.getFirstName())
                .withLastName(customerDTO.getLastName())
                .withEmail(customerDTO.getEmail())
                .withAddress(customerDTO.getAddress())
                .withPhoneNumber(customerDTO.getPhoneNumber())
                .build();
    }
}
