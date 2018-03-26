package com.javaacademy.amauryroyers.api.customer;

import com.javaacademy.amauryroyers.domain.customer.Customer;

import javax.inject.Named;
import java.util.UUID;

@Named
public class CustomerMapper {

    public CustomerDTO toDTO(Customer customer){
        return CustomerDTO.customerDTO()
                .withID(customer.getId().toString())
                .withFirstName(customer.getFirstName())
                .withLastName(customer.getLastName())
                .withEmail(customer.getEmail())
                .withAddress(customer.getAddress())
                .withPhoneNumber(customer.getPhoneNumber());
    }

    public Customer toDomain(CustomerDTO customerDTO){
        Customer customer = Customer.CustomerBuilder.customer()
                .withFirstName(customerDTO.getFirstName())
                .withLastName(customerDTO.getLastName())
                .withEmail(customerDTO.getEmail())
                .withAddress(customerDTO.getAddress())
                .withPhoneNumber(customerDTO.getPhoneNumber())
                .build();

        customer.setId(UUID.fromString(customerDTO.getID()));

        return customer;
    }
}
