package com.javaacademy.amauryroyers.api.customer;

public class CustomerDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String phoneNumber;

    public static CustomerDTO customerDTO(){
        return new CustomerDTO();
    }

    public CustomerDTO withFirstName(String firstName){
        this.firstName = firstName;
        return this;
    }

    public CustomerDTO withLastName(String lastName){
        this.lastName = lastName;
        return this;
    }

    public CustomerDTO withEmail(String email){
        this.email = email;
        return this;
    }

    public CustomerDTO withAddress(String address){
        this.address = address;
        return this;
    }

    public CustomerDTO withPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
        return this;
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
}
