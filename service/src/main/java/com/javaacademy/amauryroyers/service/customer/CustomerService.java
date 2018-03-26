package com.javaacademy.amauryroyers.service.customer;

import com.javaacademy.amauryroyers.domain.customer.Customer;
import com.javaacademy.amauryroyers.domain.customer.CustomerRepository;
import com.javaacademy.amauryroyers.service.exceptions.UnknownResourceException;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.UUID;

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

    public List<Customer> getCustomers(){
        return customerRepository.getCustomers();
    }

    public Customer getCustomer(String id){
        assertCustomerIsPresent(customerRepository.getCustomer(UUID.fromString(id)));
        return customerRepository.getCustomer(UUID.fromString(id));
    }

    private void assertCustomerIsPresent(Customer queriedCustomerById) {
        if (queriedCustomerById == null) {
            throw new UnknownResourceException("ID", Customer.class.getSimpleName());
        }
    }
}
