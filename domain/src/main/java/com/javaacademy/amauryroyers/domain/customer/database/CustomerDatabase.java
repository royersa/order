package com.javaacademy.amauryroyers.domain.customer.database;

import com.javaacademy.amauryroyers.domain.customer.Customer;

import javax.inject.Named;
import java.util.*;

@Named
public class CustomerDatabase {

    private Map<UUID, Customer> customerMap;

    public CustomerDatabase(){
        customerMap = new HashMap<>();
    }

    public Customer addCustomer(Customer customer){
        customerMap.put(customer.getId(), customer);
        return customer;
    }

    public Collection<Customer> getCustomers(){
        return customerMap.values();
    }

    public Customer getCustomer(UUID id){
        return customerMap.get(id);
    }
}
