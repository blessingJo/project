package com.opule.dao;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Query;
/*
Java Persistence API
Parameterised with generic type E
I've used JPAdao class as a wrapper around the EntityManager to provide reusable functionalities for subclasses
Main purpose of this class is to provide common operations that are shared among subclasses 
*/
public class JpaDAO<E> {
	
	//Use of entityManager to create/remove persistent entity instances,
	//to find entities by their primary key and to query over entities.
	protected EntityManager entityManager;

	//constructor because the entityManager is injected by the client code - DAO classes 
	public JpaDAO(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	//This method persists an instance of an entity to the db using EM and returns entity object
		public E create(E entity) {
			//initiating the transaction
		entityManager.getTransaction().begin();
		//this method persists the entity to the database
		entityManager.persist(entity);
		entityManager.flush();
		//refresing the object, so the objected is updated when the when return is called 
		entityManager.refresh(entity);
		//committing the transaction
		entityManager.getTransaction().commit();
		
		return entity;
		
	}
		
		public E update(E entity) {
			entityManager.getTransaction().begin();
			entity = entityManager.merge(entity);
			entityManager.getTransaction().commit();
			return entity;
			
			
		}
		
		public E find(Class<E> type, Object id) {
			E entity = entityManager.find(type, id);
			
			if (entity!= null) {
				entityManager.refresh(entity);
			}
			return entity;
		}
		
		public void delete(Class<E> type, Object id) {
			entityManager.getTransaction().begin();
			Object reference  = entityManager.getReference(type, id);
			
			entityManager.remove(reference);
			entityManager.getTransaction().commit();
		}
		
		public List<E> findWithNamedQuery(String queryName) {
			Query query = entityManager.createNamedQuery(queryName);
			return query.getResultList();
			
		}
		
		public List<E> findWithNamedQuery(String queryName, String paramName, Object paramValue) {
			Query query = entityManager.createNamedQuery(queryName);
			
			query.setParameter(paramName, paramValue);
			return query.getResultList();
		}
		

		
		public Long countWithNamedQuery(String queryName) {
			Query query = entityManager.createNamedQuery(queryName);
			
			return (long) query.getSingleResult();
		}
		
		
	
	
	

}
