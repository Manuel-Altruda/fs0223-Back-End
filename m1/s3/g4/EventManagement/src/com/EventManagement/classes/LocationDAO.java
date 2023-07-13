package com.EventManagement.classes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import com.EventManagement.utils.JpaUtil;

public class LocationDAO {
	public void save(Location location) {
        EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.persist(location);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        } finally {
            entityManager.close();
        }
    }
	
	public List<Location> getAllLocations() {
        EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {
            TypedQuery<Location> query = entityManager.createQuery("SELECT l FROM Location l", Location.class);
            return query.getResultList();
        } finally {
            entityManager.close();
        }
    }

    public Location getById(Long id) {
        EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {
            return entityManager.find(Location.class, id);
        } finally {
            entityManager.close();
        }
    }
}
