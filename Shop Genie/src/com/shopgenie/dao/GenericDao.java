package com.shopgenie.dao;


import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class GenericDao<T, ID extends Serializable> implements GenericDaoInterface<T, ID> {

	private Class<T> entity;
	private SessionFactory sessionFactory;
	private Session session;
	private final int sessionBufferSize=10;
	public GenericDao(Class<T> entity) {
		this.entity = entity;
		sessionFactory=SessionFactoryMySQL.getInstance();
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		if (sessionFactory != null)
			this.sessionFactory = sessionFactory;
		else
			System.out.println();
	}
	
	
	public void beginTransaction()
	{	
		session=sessionFactory.openSession();
		session.beginTransaction();
	}
	
	public void close()
	{
		session.getTransaction().commit();
		session.close();
	}
	
	public void end()
	{
		SessionFactoryMySQL.close();
	}
	/**
	 * Save single object
	 */
	public void save(T o) {
		
		beginTransaction();
		session.save(o);
		close();
	}

	public void saveAll(Collection<T> collection)
	{
		int count=0;
		Iterator<T> i = collection.iterator();
		beginTransaction();
		while (i.hasNext())
		  {
			session.save(i.next());
			if(count%sessionBufferSize==0)
				session.flush();
		  }
		close();
	}
	
	public void saveOrUpdate(Collection<T> collection)
	{
		int count=0;
		Iterator<T> i = collection.iterator();
		beginTransaction();
		while (i.hasNext())
		  {
			session.saveOrUpdate(i.next());
			if(count%sessionBufferSize==0)
				session.flush();
		  }
		close();
	}
	
	
	public void deleteAll(Collection<T> collection)
	{
		int count=0;
		Iterator<T> i = collection.iterator();
		beginTransaction();
		while (i.hasNext())
		  {
			session.delete(i.next());
			if(count%sessionBufferSize==0)
				
				session.flush();
		  }
		
		close();
	}
	
	public void deleteAllByID(Collection<ID> collection)
	{
		int count=0;
		Iterator<ID> i = collection.iterator();
		beginTransaction();
		while (i.hasNext())
		  {
			T o;
			o = (T) session.load(entity, i.next());
			session.delete(o);
			if(count%sessionBufferSize==0)
				
				session.flush();
		  }
		close();
	}
	
	public void flush() {
		session.flush();
	}


	public T get(ID i) {
		beginTransaction();
		T o = session.get(entity, i);
		close();
		return o;
	}

	/**
	 * Returns List of all records
	 * @return List
	 */
	@SuppressWarnings("unchecked")
	public List<T> getALL() {
		beginTransaction();
		List<T> tlist =session.createCriteria(entity).list();
		close();
		return tlist;
	}

	/**
	 * Delete object;
	 * 
	 * @param Object
	 *            of the persistent Class;
	 * @return boolean
	 */
	public boolean delete(T o) {

		try {
			beginTransaction();
			session.delete(o);
			flush();
		} catch (Exception e) {
			System.out.println("No record");
			session.clear();
			return false;
		}
		finally
		{
			close();
		}
		return true;
	}

	/**
	 * Delete object by ID;
	 * 
	 * @param ID
	 *            i
	 * @return boolean
	 */
	public boolean delete(ID id) {
		beginTransaction();
		T o;
		o = (T) session.load(entity, id);
		try {

			session.delete(o);
			flush();
		} catch (Exception e) {
			System.out.println("No record");
			return false;
		}
		finally
		{
			close();
		}

		return true;
	}

	public void update(T o) {
		beginTransaction();
		session.update(o);
		close();
	}

	public void saveOrUpdate(T o) {
		beginTransaction();
		session.saveOrUpdate(o);
		close();
	}
}
