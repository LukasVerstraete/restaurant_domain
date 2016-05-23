package com.lukas.verstraete.restaurants_domain.db;

import com.lukas.verstraete.restaurants_domain.util.DatabaseException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public abstract class Database<E> {

    private final EntityManagerFactory factory;
    private final EntityManager entityManager;
    
    public Database(String pu)
    {
        factory = Persistence.createEntityManagerFactory(pu);
        entityManager = factory.createEntityManager();
    }
    
    public void add(E object) throws DatabaseException
    {
        try
        {
            entityManager.getTransaction().begin();
            entityManager.persist(object);
            entityManager.flush();
            entityManager.getTransaction().commit();
        }
        catch(Exception e)
        {
            throw new DatabaseException(e.getMessage(), e);
        }
    }
    
    public void update(E object) throws DatabaseException
    {
        try
        {
            entityManager.getTransaction().begin();
            entityManager.merge(object);
            entityManager.flush();
            entityManager.getTransaction().commit();
        }
        catch(Exception e)
        {
            throw new DatabaseException(e.getMessage(), e);
        }
    }
    
    protected E get(Class<E> type, long id) throws DatabaseException
    {
        try
        {
            return entityManager.find(type, id);
        }
        catch(Exception e)
        {
            throw new DatabaseException(e.getMessage(), e);
        }
    }
    
    public abstract E get(long id) throws DatabaseException;
    
    protected List<E> getAll(String queryString) throws DatabaseException
    {
        try
        {
            Query query = entityManager.createQuery(queryString);
            return new ArrayList<>(query.getResultList());
        }
        catch(Exception e)
        {
            throw new DatabaseException(e.getMessage(), e);
        }
    }
    
    public abstract List<E> getAll() throws DatabaseException;
    
    public void delete(E object) throws DatabaseException
    {
        try
        {
            entityManager.getTransaction().begin();
            entityManager.remove(object);
            entityManager.flush();
            entityManager.getTransaction().commit();
        }
        catch(Exception e)
        {
            throw new DatabaseException(e.getMessage(), e);
        }
    }
    
    public void closeConnection() throws DatabaseException
    {
        try
        {
            entityManager.close();
            factory.close();
        }
        catch(Exception e)
        {
            throw new DatabaseException(e.getMessage(), e);
        }
    }

}