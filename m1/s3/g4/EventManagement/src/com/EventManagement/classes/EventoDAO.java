package com.EventManagement.classes;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import com.EventManagement.utils.JpaUtil;

import java.util.List;

public class EventoDAO {
	
	public void save(Evento evento) {
        EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.persist(evento);
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

    public Evento getById(Long id) {
        EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {
            return entityManager.find(Evento.class, id);
        } finally {
            entityManager.close();
        }
    }

    public void delete(Evento evento) {
        EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.remove(evento);
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

    public void refresh(Evento evento) {
        EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {
            entityManager.refresh(evento);
        } finally {
            entityManager.close();
        }
    }
    
    public List<Evento> getAllEventi() {
        EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {
            TypedQuery<Evento> query = entityManager.createQuery("SELECT e FROM Evento e", Evento.class);
            return query.getResultList();
        } finally {
            entityManager.close();
        }
    }
    
    public List<Evento> getPartiteVinteInCasa() {
        EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {
            TypedQuery<Evento> query = entityManager.createNamedQuery("Evento.getPartiteVinteInCasa", Evento.class);
            return query.getResultList();
        } finally {
            entityManager.close();
        }
    }

    public List<Evento> getPartiteVinteInTrasferta() {
        EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {
            TypedQuery<Evento> query = entityManager.createNamedQuery("Evento.getPartiteVinteInTrasferta", Evento.class);
            return query.getResultList();
        } finally {
            entityManager.close();
        }
    }

    public List<Evento> getPartitePareggiate() {
        EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {
            TypedQuery<Evento> query = entityManager.createNamedQuery("Evento.getPartitePareggiate", Evento.class);
            return query.getResultList();
        } finally {
            entityManager.close();
        }
    }

    public List<Evento> getConcertiInStreaming(boolean inStreaming) {
        EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {
            TypedQuery<Evento> query = entityManager.createQuery("SELECT e FROM Evento e WHERE e.tipoEvento = :tipo AND e.inStreaming = :inStreaming", Evento.class);
            query.setParameter("tipo", TipoEvento.CONCERTO);
            query.setParameter("inStreaming", inStreaming);
            return query.getResultList();
        } finally {
            entityManager.close();
        }
    }

    public List<Evento> getConcertiPerGenere(List<GenereConcerto> generi) {
        EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {
            TypedQuery<Evento> query = entityManager.createQuery("SELECT e FROM Evento e WHERE e.tipoEvento = :tipo AND e.genere IN :generi", Evento.class);
            query.setParameter("tipo", TipoEvento.CONCERTO);
            query.setParameter("generi", generi);
            return query.getResultList();
        } finally {
            entityManager.close();
        }
    }

}
