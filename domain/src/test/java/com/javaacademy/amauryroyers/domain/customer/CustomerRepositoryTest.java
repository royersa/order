package com.javaacademy.amauryroyers.domain.customer;

import com.javaacademy.amauryroyers.domain.customer.database.CustomerDatabase;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CustomerRepositoryTest {

    @Mock
    private CustomerDatabase customerDatabase;

    @InjectMocks
    private CustomerRepository customerRepository;

    @Test
    public void createCustomer_happyPath() {
        Customer customer = Customer.CustomerBuilder.customer()
                .withFirstName("John")
                .withLastName("Doe")
                .withEmail("john.doe@unknown.com")
                .withAddress("404 Whatever Street, 1337 GHOSTTOWN")
                .withPhoneNumber("0404/00.00.00")
                .build();

        Mockito.when(customerRepository.createCustomer(customer)).thenReturn(customer);

        Assertions.assertThat(customerRepository.createCustomer(customer)).isEqualTo(customer);
    }

    @Test
    public void getCustomer_givenACustomerID_thenReturnTheCorrespondingCustomer() {
        Customer customer = Customer.CustomerBuilder.customer()
                .withFirstName("John")
                .withLastName("Doe")
                .withEmail("john.doe@unknown.com")
                .withAddress("404 Whatever Street, 1337 GHOSTTOWN")
                .withPhoneNumber("0404/00.00.00")
                .build();

        Mockito.when(customerRepository.createCustomer(customer)).thenReturn(customer);
        Customer customer1 = customerRepository.createCustomer(customer);
        Mockito.when(customerRepository.getCustomer(customer1.getId())).thenReturn(customer);

        Assertions.assertThat(customerRepository.getCustomer(customer1.getId())).isEqualTo(customer);
    }
}