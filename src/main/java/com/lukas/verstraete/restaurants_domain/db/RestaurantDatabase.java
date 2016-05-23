package com.lukas.verstraete.restaurants_domain.db;

import com.lukas.verstraete.restaurants_domain.domain.Restaurant;
import com.lukas.verstraete.restaurants_domain.util.DatabaseException;
import java.util.List;

public class RestaurantDatabase extends Database<Restaurant>
{
    
    public RestaurantDatabase(String pu)
    {
        super(pu);
    }

    @Override
    public Restaurant get(long id) throws DatabaseException 
    {
        return super.get(Restaurant.class, id);
    }

    @Override
    public List getAll() throws DatabaseException 
    {
        return super.getAll("select restaurant from Restaurant restaurant");
    }
    
}