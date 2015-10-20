package com.shopgenie.dao;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryMySQL {
	
	private static SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
	private SessionFactoryMySQL()
	{
		
	}
	public static SessionFactory getInstance()
	{	
		return sessionFactory;
	}
	public static void close(){
		sessionFactory.close();
	}
}
