package com.bridgelabz.greetingapp.exception;

public class GreetingAppException extends Exception {

    public enum ExceptionType { DATA_NOT_FOUND }

    public ExceptionType type;

    public GreetingAppException(ExceptionType type, String message) {
        super(message);
        this.type = type;
    }
}
