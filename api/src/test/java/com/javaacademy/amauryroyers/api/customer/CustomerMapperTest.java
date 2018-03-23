package com.javaacademy.amauryroyers.api.customer;

import com.javaacademy.amauryroyers.domain.customer.Customer;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomerMapperTest {

    private CustomerMapper customerMapper;

    @Before
    public void instantiateMapper(){
        customerMapper = new CustomerMapper();
    }

    @Test
    public void toDto_givenACustomer_thenMapAllFieldsToCustomerDTO() {
        Customer customer = Customer.CustomerBuilder.customer()
                .withFirstName("John")
                .withLastName("Doe")
                .withEmail("john.doe@unknown.com")
                .withAddress("404 Whatever Street, 1337 GHOSTTOWN")
                .withPhoneNumber("0404/00.00.00")
                .build();

        CustomerDTO customerDTO = customerMapper.toDTO(customer);

        Assertions.assertThat(customerDTO.getFirstName()).isEqualTo(customer.getFirstName());
        Assertions.assertThat(customerDTO.getLastName()).isEqualTo(customer.getLastName());
        Assertions.assertThat(customerDTO.getEmail()).isEqualTo(customer.getEmail());
        Assertions.assertThat(customerDTO.getAddress()).isEqualTo(customer.getAddress());
        Assertions.assertThat(customerDTO.getPhoneNumber()).isEqualTo(customer.getPhoneNumber());
    }

    @Test
    public void toDomain_givenACustomerDTO_thenMapAllFieldsToCustomer() {
        CustomerDTO customerDTO = CustomerDTO.customerDTO()
                .withFirstName("John")
                .withLastName("Doe")
                .withEmail("john.doe@unknown.com")
                .withAddress("404 Whatever Street, 1337 GHOSTTOWN")
                .withPhoneNumber("0404/00.00.00");

        Customer customer = customerMapper.toDomain(customerDTO);

        Assertions.assertThat(customer.getFirstName()).isEqualTo(customerDTO.getFirstName());
        Assertions.assertThat(customer.getLastName()).isEqualTo(customerDTO.getLastName());
        Assertions.assertThat(customer.getEmail()).isEqualTo(customerDTO.getEmail());
        Assertions.assertThat(customer.getAddress()).isEqualTo(customerDTO.getAddress());
        Assertions.assertThat(customer.getPhoneNumber()).isEqualTo(customerDTO.getPhoneNumber());
    }
}