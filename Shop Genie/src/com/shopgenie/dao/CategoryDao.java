package com.shopgenie.dao;

import java.util.List;

import org.hibernate.Query;

import com.shopgenie.entities.Category;
import com.shopgenie.entities.Seller;

public class CategoryDao extends GenericDao<Category, Long>
{

    public CategoryDao(Class<Category> entity)
    {
	super(entity);
    }

    public CategoryDao()
    {

	super(Category.class);
    }

    public Category getByName(String name)
    {
	Query query = startSession().createQuery("From Category where categoryName=?");
	query.setParameter(0, name);
	List results = query.list();
	if (results.isEmpty())
	    return null;
	return (Category) results.get(0);
    }
}
