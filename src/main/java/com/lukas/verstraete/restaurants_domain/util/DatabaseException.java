package com.lukas.verstraete.restaurants_domain.util;

public class DatabaseException extends RuntimeException{
    
    public DatabaseException()
    {
        super();
    }
    
    public DatabaseException(String message)
    {
        super(message);
    }
    
    public DatabaseException(String message, Throwable exception)
    {
        super(message, exception);
    }
}