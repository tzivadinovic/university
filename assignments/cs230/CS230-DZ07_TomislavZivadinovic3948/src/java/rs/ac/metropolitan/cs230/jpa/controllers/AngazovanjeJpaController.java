/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.metropolitan.cs230.jpa.controllers;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.UserTransaction;
import rs.ac.metropolitan.cs230.jpa.controllers.exceptions.NonexistentEntityException;
import rs.ac.metropolitan.cs230.jpa.controllers.exceptions.PreexistingEntityException;
import rs.ac.metropolitan.cs230.jpa.controllers.exceptions.RollbackFailureException;
import rs.ac.metropolitan.cs230.jpa.entity.Angazovanje;
import rs.ac.metropolitan.cs230.jpa.entity.Profesor;
import rs.ac.metropolitan.cs230.jpa.entity.Predmet;

/**
 *
 * @author korisnik
 */
public class AngazovanjeJpaController implements Serializable {

    public AngazovanjeJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Angazovanje angazovanje) throws PreexistingEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Profesor profesorId = angazovanje.getProfesorId();
            if (profesorId != null) {
                profesorId = em.getReference(profesorId.getClass(), profesorId.getProfesorId());
                angazovanje.setProfesorId(profesorId);
            }
            Predmet predmetId = angazovanje.getPredmetId();
            if (predmetId != null) {
                predmetId = em.getReference(predmetId.getClass(), predmetId.getPredmetId());
                angazovanje.setPredmetId(predmetId);
            }
            em.persist(angazovanje);
            if (profesorId != null) {
                profesorId.getAngazovanjeCollection().add(angazovanje);
                profesorId = em.merge(profesorId);
            }
            if (predmetId != null) {
                predmetId.getAngazovanjeCollection().add(angazovanje);
                predmetId = em.merge(predmetId);
            }
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            if (findAngazovanje(angazovanje.getAngazovanjeId()) != null) {
                throw new PreexistingEntityException("Angazovanje " + angazovanje + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Angazovanje angazovanje) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Angazovanje persistentAngazovanje = em.find(Angazovanje.class, angazovanje.getAngazovanjeId());
            Profesor profesorIdOld = persistentAngazovanje.getProfesorId();
            Profesor profesorIdNew = angazovanje.getProfesorId();
            Predmet predmetIdOld = persistentAngazovanje.getPredmetId();
            Predmet predmetIdNew = angazovanje.getPredmetId();
            if (profesorIdNew != null) {
                profesorIdNew = em.getReference(profesorIdNew.getClass(), profesorIdNew.getProfesorId());
                angazovanje.setProfesorId(profesorIdNew);
            }
            if (predmetIdNew != null) {
                predmetIdNew = em.getReference(predmetIdNew.getClass(), predmetIdNew.getPredmetId());
                angazovanje.setPredmetId(predmetIdNew);
            }
            angazovanje = em.merge(angazovanje);
            if (profesorIdOld != null && !profesorIdOld.equals(profesorIdNew)) {
                profesorIdOld.getAngazovanjeCollection().remove(angazovanje);
                profesorIdOld = em.merge(profesorIdOld);
            }
            if (profesorIdNew != null && !profesorIdNew.equals(profesorIdOld)) {
                profesorIdNew.getAngazovanjeCollection().add(angazovanje);
                profesorIdNew = em.merge(profesorIdNew);
            }
            if (predmetIdOld != null && !predmetIdOld.equals(predmetIdNew)) {
                predmetIdOld.getAngazovanjeCollection().remove(angazovanje);
                predmetIdOld = em.merge(predmetIdOld);
            }
            if (predmetIdNew != null && !predmetIdNew.equals(predmetIdOld)) {
                predmetIdNew.getAngazovanjeCollection().add(angazovanje);
                predmetIdNew = em.merge(predmetIdNew);
            }
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = angazovanje.getAngazovanjeId();
                if (findAngazovanje(id) == null) {
                    throw new NonexistentEntityException("The angazovanje with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Angazovanje angazovanje;
            try {
                angazovanje = em.getReference(Angazovanje.class, id);
                angazovanje.getAngazovanjeId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The angazovanje with id " + id + " no longer exists.", enfe);
            }
            Profesor profesorId = angazovanje.getProfesorId();
            if (profesorId != null) {
                profesorId.getAngazovanjeCollection().remove(angazovanje);
                profesorId = em.merge(profesorId);
            }
            Predmet predmetId = angazovanje.getPredmetId();
            if (predmetId != null) {
                predmetId.getAngazovanjeCollection().remove(angazovanje);
                predmetId = em.merge(predmetId);
            }
            em.remove(angazovanje);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Angazovanje> findAngazovanjeEntities() {
        return findAngazovanjeEntities(true, -1, -1);
    }

    public List<Angazovanje> findAngazovanjeEntities(int maxResults, int firstResult) {
        return findAngazovanjeEntities(false, maxResults, firstResult);
    }

    private List<Angazovanje> findAngazovanjeEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Angazovanje.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Angazovanje findAngazovanje(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Angazovanje.class, id);
        } finally {
            em.close();
        }
    }

    public int getAngazovanjeCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Angazovanje> rt = cq.from(Angazovanje.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
