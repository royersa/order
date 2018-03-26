package com.javaacademy.amauryroyers.domain.customer.database;

import com.javaacademy.amauryroyers.domain.customer.Customer;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named
public class CustomerDatabase {

    private List<Customer> customerList;

    public CustomerDatabase(){
        customerList = new ArrayList<>();
    }

    public Customer addCustomer(Customer customer){
        customerList.add(customer);
        return customer;
    }
}
