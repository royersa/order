package com.javaacademy.amauryroyers.domain.customer;

import java.util.Objects;
import java.util.UUID;

public class Customer {
    private UUID id;
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String phoneNumber;

    private Customer(String firstName, String lastName, String email, String address, String phoneNumber){
        id = UUID.randomUUID();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public UUID getId() {
        return id;
    }

    public Customer setId(UUID id){
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(getId(), customer.getId()) &&
                Objects.equals(getFirstName(), customer.getFirstName()) &&
                Objects.equals(getLastName(), customer.getLastName()) &&
                Objects.equals(getEmail(), customer.getEmail()) &&
                Objects.equals(getAddress(), customer.getAddress()) &&
                Objects.equals(getPhoneNumber(), customer.getPhoneNumber());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId(), getFirstName(), getLastName(), getEmail(), getAddress(), getPhoneNumber());
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
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
