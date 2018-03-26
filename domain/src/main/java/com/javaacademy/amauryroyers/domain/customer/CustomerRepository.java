package com.javaacademy.amauryroyers.domain.customer;

import com.javaacademy.amauryroyers.domain.customer.database.CustomerDatabase;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

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

    public List<Customer> getCustomers(){
        return Collections.unmodifiableList(new ArrayList<>(customerDatabase.getCustomers()));
    }

    public Customer getCustomer(UUID id){
        return customerDatabase.getCustomer(id);
    }
}
