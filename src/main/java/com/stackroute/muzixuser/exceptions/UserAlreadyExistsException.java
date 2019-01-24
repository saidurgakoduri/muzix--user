package com.stackroute.muzixuser.exceptions;

public class UserAlreadyExistsException extends Exception {
    private String message;

    public UserAlreadyExistsException(){
        this.message= message;
    }

    public UserAlreadyExistsException(String message)
    {
        super(message);
        this.message=message;
    }
}
