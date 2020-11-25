package com.opule.dao;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class JpaDAO<E> {
	
	protected EntityManager entityManager;

	public JpaDAO(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	//This method persists an instance of an entity to the db using EM and returns entity object
		public E create(E entity) {
		entityManager.getTransaction().begin();
		
		entityManager.persist(entity);
		entityManager.flush();
		entityManager.refresh(entity);
		
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
