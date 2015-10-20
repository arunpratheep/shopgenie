package com.shopgenie.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDaoInterface <T,Id extends Serializable>{
		
	public void save(T o);
	public void flush();
	public T get(Id i);
	public List<T> getALL();
	public boolean delete(T o);
	public boolean delete(Id id);
	public void update(T o);
	public void saveOrUpdate(T o);
	
}
