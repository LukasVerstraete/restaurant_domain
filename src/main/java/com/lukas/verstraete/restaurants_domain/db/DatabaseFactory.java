package com.lukas.verstraete.restaurants_domain.db;

import com.lukas.verstraete.restaurants_domain.domain.Adress;
import com.lukas.verstraete.restaurants_domain.domain.Restaurant;
import com.lukas.verstraete.restaurants_domain.util.DatabaseException;

public class DatabaseFactory
{
    
    public final String persistanceUnit = "";
    
    public DatabaseFactory() {}
    
    public Database getDatabase(Class clazz) throws DatabaseException
    {
        if(clazz.getCanonicalName().equals(Restaurant.class.getCanonicalName()))
            return new RestaurantDatabase("restaurantPU");
        else if(clazz.getCanonicalName().equals(Adress.class.getCanonicalName()))
            return new AdressDatabase("restaurantPU");
        else 
            throw new DatabaseException("There is no database of class: " + clazz.getCanonicalName());
    }
    
}