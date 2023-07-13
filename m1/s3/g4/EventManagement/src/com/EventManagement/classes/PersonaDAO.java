package com.EventManagement.classes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import com.EventManagement.utils.JpaUtil;

public class PersonaDAO {
	public void save(Persona persona) {
        EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.persist(persona);
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
	
	public List<Persona> getAllPersone() {
        EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {
            TypedQuery<Persona> query = entityManager.createQuery("SELECT p FROM Persona p", Persona.class);
            return query.getResultList();
        } finally {
            entityManager.close();
        }
    }
	
	public List<GaraDiAtletica> getGareDiAtleticaPerVincitore(Persona vincitore) {
        EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {
            TypedQuery<GaraDiAtletica> query = entityManager.createNamedQuery("Persona.getGareDiAtleticaPerVincitore", GaraDiAtletica.class);
            query.setParameter("vincitore", vincitore);
            return query.getResultList();
        } finally {
            entityManager.close();
        }
    }

    public List<GaraDiAtletica> getGareDiAtleticaPerPartecipante(Persona partecipante) {
        EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {
            TypedQuery<GaraDiAtletica> query = entityManager.createNamedQuery("Persona.getGareDiAtleticaPerPartecipante", GaraDiAtletica.class);
            query.setParameter("partecipante", partecipante);
            return query.getResultList();
        } finally {
            entityManager.close();
        }
    }

    public List<Evento> getEventiSoldOut() {
        EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {
            TypedQuery<Evento> query = entityManager.createNamedQuery("Persona.getEventiSoldOut", Evento.class);
            query.setParameter("stato", StatoPartecipazione.CONFERMATA);
            return query.getResultList();
        } finally {
            entityManager.close();
        }
    }

    public List<Evento> getEventiPerInvitato(Persona invitato) {
        EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {
            TypedQuery<Evento> query = entityManager.createNamedQuery("Persona.getEventiPerInvitato", Evento.class);
            query.setParameter("stato", StatoPartecipazione.CONFERMATA);
            query.setParameter("invitato", invitato);
            return query.getResultList();
        } finally {
            entityManager.close();
        }
    }

    public Persona getById(Long id) {
        EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {
            return entityManager.find(Persona.class, id);
        } finally {
            entityManager.close();
        }
    }
}
