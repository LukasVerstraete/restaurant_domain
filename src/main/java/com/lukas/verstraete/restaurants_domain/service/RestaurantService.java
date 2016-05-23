package com.lukas.verstraete.restaurants_domain.service;

import com.lukas.verstraete.restaurants_domain.db.Database;
import com.lukas.verstraete.restaurants_domain.db.DatabaseFactory;
import com.lukas.verstraete.restaurants_domain.domain.Restaurant;
import com.lukas.verstraete.restaurants_domain.util.ServiceException;
import java.util.List;

public class RestaurantService
{
    
    public Database<Restaurant> database;
    
    public RestaurantService()
    {
        DatabaseFactory factory = new DatabaseFactory();
        database = factory.getDatabase(Restaurant.class);
    }
    
    public void add(Restaurant restaurant) throws ServiceException
    {
        try 
        {
            database.add(restaurant);
        }
        catch(Exception e)
        {
            throw new ServiceException(e.getMessage(), e);
        }
    }
    
    public Restaurant get(long id) throws ServiceException
    {
        try 
        {
            return database.get(id);
        }
        catch(Exception e)
        {
            throw new ServiceException(e.getMessage(), e);
        }
    }
    
    public List<Restaurant> getAll() throws ServiceException
    {
        try 
        {
            return database.getAll();
        }
        catch(Exception e)
        {
            throw new ServiceException(e.getMessage(), e);
        }
    }
    
    public void update(Restaurant restaurant) throws ServiceException
    {
        try 
        {
            database.update(restaurant);
        }
        catch(Exception e)
        {
            throw new ServiceException(e.getMessage(), e);
        }
    }
    
    public void delete(long id) throws ServiceException
    {
        try 
        {
            database.delete(get(id));
        }
        catch(Exception e)
        {
            throw new ServiceException(e.getMessage(), e);
        }
    }
    
    public void closeConnection() throws ServiceException
    {
        try 
        {
            database.closeConnection();
        }
        catch(Exception e)
        {
            throw new ServiceException(e.getMessage(), e);
        }
    }
}