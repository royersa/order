package com.javaacademy.amauryroyers.domain.customer.database;

import com.javaacademy.amauryroyers.domain.customer.Customer;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class CustomerDatabaseTest {

    @Test
    public void addCustomer_happyPath() {
        Customer customer = Customer.CustomerBuilder.customer()
                            .withFirstName("John")
                            .withLastName("Doe")
                            .withEmail("john.doe@unknown.com")
                            .withAddress("404 Whatever Street, 1337 GHOSTTOWN")
                            .withPhoneNumber("0404/00.00.00")
                            .build();

        CustomerDatabase customerDatabase = new CustomerDatabase();

        Assertions.assertThat(customerDatabase.addCustomer(customer)).isEqualTo(customer);
    }
}