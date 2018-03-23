package com.javaacademy.amauryroyers.service.customer;

import com.javaacademy.amauryroyers.domain.customer.Customer;
import com.javaacademy.amauryroyers.domain.customer.CustomerRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import javax.inject.Inject;

import java.util.Arrays;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerService customerService;

    @Test
    public void registerCustomer_happyPath() {
        Customer customer = Customer.CustomerBuilder.customer()
                .withFirstName("John")
                .withLastName("Doe")
                .withEmail("john.doe@unknown.com")
                .withAddress("404 Whatever Street, 1337 GHOSTTOWN")
                .withPhoneNumber("0404/00.00.00")
                .build();

        Mockito.when(customerRepository.createCustomer(customer)).thenReturn(customer);

        Assertions.assertThat(customerService.registerCustomer(customer)).isEqualTo(customer);
    }
}