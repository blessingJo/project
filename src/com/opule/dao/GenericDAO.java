package com.opule.dao;

import java.util.List;

public interface GenericDAO<E>{

	
	//parameter S for type
	public E create (E e);
	
	public E update(E e);
	
	public E get(Object id);
	
	public void delete(Object id);
	
	public List listAll();
	
	public long count();
	
	
	

}
