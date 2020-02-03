package com.farnborough.robot;

public class NotAValidDirectionException extends RuntimeException {

    public NotAValidDirectionException(String message){
        super(message);
    }
}
