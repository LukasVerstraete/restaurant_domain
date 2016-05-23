package com.lukas.verstraete.restaurants_domain.service;

import com.lukas.verstraete.restaurants_domain.domain.Adress;
import com.lukas.verstraete.restaurants_domain.domain.Restaurant;
import com.lukas.verstraete.restaurants_domain.util.ServiceException;
import java.util.List;

public class RestaurantFacade 
{
    
    private RestaurantService restaurantService;
    private AdressService adressService; 
    
    public RestaurantFacade() 
    {
        restaurantService = new RestaurantService();
        adressService = new AdressService();
    }
    
    
    /*******************************************/
    /***************RESTAURANTS*****************/
    /*******************************************/
    
    public void addRestaurant(Restaurant restaurant) throws ServiceException
    {
        restaurantService.add(restaurant);
    }
    
    public Restaurant getRestaurant(long id) throws ServiceException
    {
        return restaurantService.get(id);
    }
    
    public List<Restaurant> getAllRestaurants() throws ServiceException
    {
        return restaurantService.getAll();
    }
    
    public void updateRestaurant(Restaurant restaurant) throws ServiceException
    {
        restaurantService.update(restaurant);
    }
    
    public void deleteRestaurant(long id) throws ServiceException
    {
        restaurantService.delete(id);
    }
    
    /*******************************************/
    /*****************ADRESSES******************/
    /*******************************************/
    
    public void addAdress(Adress adress) throws ServiceException
    {
        adressService.add(adress);
    }
    
    public Adress getAdress(long id) throws ServiceException
    {
        return adressService.get(id);
    }
    
    public List<Adress> getAllAdresses() throws ServiceException
    {
        return adressService.getAll();
    }
    
    public void updateAdress(Adress adress) throws ServiceException
    {
        adressService.update(adress);
    }
    
    public void deleteAdress(long id) throws ServiceException
    {
        adressService.delete(id);
    }
    
    ////////////////////////////////////////////////
    
    public void closeConnection() throws ServiceException
    {
        restaurantService.closeConnection();
        adressService.closeConnection();
    }
}