package com.stackroute.muzixuser.exceptions;

public class UserNotFoundException extends Throwable {
    private String message;

    public UserNotFoundException(){}

    public UserNotFoundException(String message)
    {
        this.message = message;
    }
}
