package com.javaacademy.amauryroyers.domain.customer;

import com.javaacademy.amauryroyers.domain.customer.databases.CustomerDatabase;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class CustomerRepository {

    @Inject
    private CustomerDatabase customerDatabase;

    public CustomerRepository(CustomerDatabase customerDatabase) {
        this.customerDatabase = customerDatabase;
    }

    public Customer createCustomer(Customer customer){
        return customerDatabase.addCustomer(customer);
    }
}
