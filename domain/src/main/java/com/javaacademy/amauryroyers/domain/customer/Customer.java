package com.javaacademy.amauryroyers.domain.customer;

import java.util.Objects;

public class Customer {
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String phoneNumber;

    private Customer(String firstName, String lastName, String email, String address, String phoneNumber){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(getFirstName(), customer.getFirstName()) &&
                Objects.equals(getLastName(), customer.getLastName()) &&
                Objects.equals(getEmail(), customer.getEmail()) &&
                Objects.equals(getAddress(), customer.getAddress()) &&
                Objects.equals(getPhoneNumber(), customer.getPhoneNumber());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getFirstName(), getLastName(), getEmail(), getAddress(), getPhoneNumber());
    }

    @Override
    public String toString() {
        return "Customer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    public static class CustomerBuilder{
        private String firstName;
        private String lastName;
        private String email;
        private String address;
        private String phoneNumber;

        public static CustomerBuilder customer(){
            return new CustomerBuilder();
        }

        public CustomerBuilder withFirstName(String firstName){
            this.firstName = firstName;
            return this;
        }

        public CustomerBuilder withLastName(String lastName){
            this.lastName = lastName;
            return this;
        }

        public CustomerBuilder withEmail(String email){
            this.email = email;
            return this;
        }

        public CustomerBuilder withAddress(String address){
            this.address = address;
            return this;
        }

        public CustomerBuilder withPhoneNumber(String phoneNumber){
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Customer build(){
            return new Customer(firstName, lastName, email, address, phoneNumber);
        }
    }
}
