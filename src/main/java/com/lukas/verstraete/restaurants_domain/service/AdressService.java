package com.lukas.verstraete.restaurants_domain.service;

import com.lukas.verstraete.restaurants_domain.db.Database;
import com.lukas.verstraete.restaurants_domain.db.DatabaseFactory;
import com.lukas.verstraete.restaurants_domain.domain.Adress;
import com.lukas.verstraete.restaurants_domain.util.ServiceException;
import java.util.List;

public class AdressService
{
    public Database<Adress> database;
    
    public AdressService()
    {
        DatabaseFactory factory = new DatabaseFactory();
        database = factory.getDatabase(Adress.class);
    }
    
    public void add(Adress adress) throws ServiceException
    {
        try 
        {
            database.add(adress);
        }
        catch(Exception e)
        {
            throw new ServiceException(e.getMessage(), e);
        }
    }
    
    public Adress get(long id) throws ServiceException
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
    
    public List<Adress> getAll() throws ServiceException
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
    
    public void update(Adress adress) throws ServiceException
    {
        try 
        {
            database.update(adress);
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