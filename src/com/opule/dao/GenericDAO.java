package com.opule.dao;

import java.util.List;

//GenericDAO interface 
//class is parameterized with E - stands for the type 
public interface GenericDAO<E>{

	
	//method returns E 
	//using generic type to indicate E for an entity
	public E create (E e);
	public E update(E e);
	public E get(Object id);
	public void delete(Object id);
	public List listAll();
	public long count();
	
	
	

}
