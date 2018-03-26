package com.javaacademy.amauryroyers.service.exceptions;

public class UnknownResourceException extends OrderException {

    public UnknownResourceException(String field, String resource){
        super(String.format("We could not find a %s for the provided %s", resource, field));
    }
}
