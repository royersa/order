package com.javaacademy.amauryroyers.service.exceptions;

public abstract class OrderException extends RuntimeException {

    public OrderException(String message){
        super(message);
    }
}
