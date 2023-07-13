package com.EventManagement.classes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import com.EventManagement.utils.JpaUtil;

public class PartecipazioneDAO {
	public void save(Partecipazione partecipazione) {
        EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.persist(partecipazione);
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
	
	public List<Partecipazione> getAllPartecipazioni() {
        EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {
            TypedQuery<Partecipazione> query = entityManager.createQuery("SELECT p FROM Partecipazione p", Partecipazione.class);
            return query.getResultList();
        } finally {
            entityManager.close();
        }
    }
	
	public List<Partecipazione> getPartecipazioniDaConfermarePerEvento(Evento evento) {
        EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {
            TypedQuery<Partecipazione> query = entityManager.createNamedQuery("Partecipazione.getPartecipazioniDaConfermarePerEvento", Partecipazione.class);
            query.setParameter("evento", evento);
            query.setParameter("stato", StatoPartecipazione.DA_CONFERMARE);
            return query.getResultList();
        } finally {
            entityManager.close();
        }
    }

    public Partecipazione getById(Long id) {
        EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {
            return entityManager.find(Partecipazione.class, id);
        } finally {
            entityManager.close();
        }
    }
}
