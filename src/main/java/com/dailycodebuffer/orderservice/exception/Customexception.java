package com.dailycodebuffer.orderservice.exception;


import lombok.Data;

@Data
public class Customexception extends RuntimeException{
    private String errorcode;
    private int status;
    public Customexception(String message, String errorcode, int status){
        super(message);
        this.errorcode=errorcode;
        this.status=status;
    }
}
