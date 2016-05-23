package com.lukas.verstraete.restaurants_domain.db;

import com.lukas.verstraete.restaurants_domain.domain.Adress;
import com.lukas.verstraete.restaurants_domain.util.DatabaseException;
import java.util.List;

public class AdressDatabase extends Database<Adress>
{

    public AdressDatabase(String pu)
    {
        super(pu);
    }

    @Override
    public Adress get(long id) throws DatabaseException 
    {
        return super.get(Adress.class, id);
    }

    @Override
    public List getAll() throws DatabaseException 
    {
        return super.getAll("select adress from Adress adress");
    }
    
}