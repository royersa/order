package com.javaacademy.amauryroyers.domain.customer;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomerTest {

    @Test
    public void equals_givenTwoSimilarCustomers_thenCheckThatTheyAreEqual() {
        Customer customer = Customer.CustomerBuilder.customer()
                .withFirstName("John")
                .withLastName("Doe")
                .withEmail("john.doe@unknown.com")
                .withAddress("404 Whatever Street, 1337 GHOSTTOWN")
                .withPhoneNumber("0404/00.00.00")
                .build();

        Customer customer2 = Customer.CustomerBuilder.customer()
                .withFirstName("John")
                .withLastName("Doe")
                .withEmail("john.doe@unknown.com")
                .withAddress("404 Whatever Street, 1337 GHOSTTOWN")
                .withPhoneNumber("0404/00.00.00")
                .build();

        customer2.setId(customer.getId());

        boolean result = customer.equals(customer2);

        Assertions.assertThat(result).isTrue();
    }

    @Test
    public void toString_givenACustomer_thenReturnTheCustomerDataAsString() {
        Customer customer = Customer.CustomerBuilder.customer()
                .withFirstName("John")
                .withLastName("Doe")
                .withEmail("john.doe@unknown.com")
                .withAddress("404 Whatever Street, 1337 GHOSTTOWN")
                .withPhoneNumber("0404/00.00.00")
                .build();

        String result = customer.toString();

        Assertions.assertThat(result).isEqualTo("Customer{id=" + customer.getId() + ", firstName='John', lastName='Doe', email='john.doe@unknown.com', address='404 Whatever Street, 1337 GHOSTTOWN', phoneNumber='0404/00.00.00'}");
    }
}