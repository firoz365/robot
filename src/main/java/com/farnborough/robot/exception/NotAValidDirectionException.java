package com.farnborough.robot.exception;

public class NotAValidDirectionException extends RuntimeException {

    public NotAValidDirectionException(String message){
        super(message);
    }
}
