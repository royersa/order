package com.javaacademy.amauryroyers.service.customer;

import com.javaacademy.amauryroyers.domain.customer.Customer;
import com.javaacademy.amauryroyers.domain.customer.CustomerRepository;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Inject
    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    public Customer registerCustomer(Customer customer){
        return customerRepository.createCustomer(customer);
    }
}
