package com.xbach.user.exceptions;

public class LoginException extends RuntimeException{
    public LoginException(String message){
        super(message);
    }
}