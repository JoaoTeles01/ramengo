package com.api.ramengo.exceptions;

public class OrderException extends RuntimeException{
    public OrderException(String message){
        super(message);
    }
}
