package com.javaacademy.amauryroyers.api.customer;

import com.javaacademy.amauryroyers.domain.customer.CustomerRepository;
import com.javaacademy.amauryroyers.service.customer.CustomerService;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.inject.Inject;

import static com.javaacademy.amauryroyers.api.customer.CustomerDTO.customerDTO;
import static org.junit.Assert.*;
import static org.springframework.boot.SpringApplication.run;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CustomerControllerIntegrationTest.CustomerControllerIntegrationTestRunner.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CustomerControllerIntegrationTest {

    @LocalServerPort
    private int port;

    @Inject
    private CustomerRepository customerRepository;

    @Test
    public void registerCustomer_givenAPostRequestOfACustomer_thenCreatesANewCustomer() {
        CustomerDTO customerDTO = new TestRestTemplate()
                .postForObject(String.format("http://localhost:%s/%s", port, "customer"),
                        customerDTO().withID("00000000-0000-0000-0000-000000000000")
                                .withFirstName("John")
                                .withLastName("Doe")
                                .withEmail("john.doe@unknown.com")
                                .withAddress("404 Whatever Street, 1337 GHOSTTOWN")
                                .withPhoneNumber("0404/00.00.00"),
                        CustomerDTO.class);

        Assertions.assertThat(customerDTO.getID()).isEqualTo("00000000-0000-0000-0000-000000000000");
        Assertions.assertThat(customerDTO.getFirstName()).isEqualTo("John");
        Assertions.assertThat(customerDTO.getLastName()).isEqualTo("Doe");
        Assertions.assertThat(customerDTO.getEmail()).isEqualTo("john.doe@unknown.com");
        Assertions.assertThat(customerDTO.getAddress()).isEqualTo("404 Whatever Street, 1337 GHOSTTOWN");
        Assertions.assertThat(customerDTO.getPhoneNumber()).isEqualTo("0404/00.00.00");
    }

    @SpringBootApplication(scanBasePackageClasses = {CustomerRepository.class, CustomerService.class, CustomerMapper.class})
    public static class CustomerControllerIntegrationTestRunner{
        public static void main(String[] args) {
            run(CustomerControllerIntegrationTestRunner.class, args);
        }
    }
}