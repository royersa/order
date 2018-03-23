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

        Assertions.assertThat(customerDTO).isEqualToComparingFieldByField(customer);
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

        Assertions.assertThat(customer).isEqualToComparingFieldByField(customerDTO);
    }
}