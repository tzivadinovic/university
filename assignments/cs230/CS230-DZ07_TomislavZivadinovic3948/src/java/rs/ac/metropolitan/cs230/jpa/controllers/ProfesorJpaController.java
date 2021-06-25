/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.metropolitan.cs230.jpa.controllers;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import rs.ac.metropolitan.cs230.jpa.entity.Angazovanje;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.UserTransaction;
import rs.ac.metropolitan.cs230.jpa.controllers.exceptions.NonexistentEntityException;
import rs.ac.metropolitan.cs230.jpa.controllers.exceptions.PreexistingEntityException;
import rs.ac.metropolitan.cs230.jpa.controllers.exceptions.RollbackFailureException;
import rs.ac.metropolitan.cs230.jpa.entity.Profesor;

/**
 *
 * @author korisnik
 */
public class ProfesorJpaController implements Serializable {

    public ProfesorJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Profesor profesor) throws PreexistingEntityException, RollbackFailureException, Exception {
        if (profesor.getAngazovanjeCollection() == null) {
            profesor.setAngazovanjeCollection(new ArrayList<Angazovanje>());
        }
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Collection<Angazovanje> attachedAngazovanjeCollection = new ArrayList<Angazovanje>();
            for (Angazovanje angazovanjeCollectionAngazovanjeToAttach : profesor.getAngazovanjeCollection()) {
                angazovanjeCollectionAngazovanjeToAttach = em.getReference(angazovanjeCollectionAngazovanjeToAttach.getClass(), angazovanjeCollectionAngazovanjeToAttach.getAngazovanjeId());
                attachedAngazovanjeCollection.add(angazovanjeCollectionAngazovanjeToAttach);
            }
            profesor.setAngazovanjeCollection(attachedAngazovanjeCollection);
            em.persist(profesor);
            for (Angazovanje angazovanjeCollectionAngazovanje : profesor.getAngazovanjeCollection()) {
                Profesor oldProfesorIdOfAngazovanjeCollectionAngazovanje = angazovanjeCollectionAngazovanje.getProfesorId();
                angazovanjeCollectionAngazovanje.setProfesorId(profesor);
                angazovanjeCollectionAngazovanje = em.merge(angazovanjeCollectionAngazovanje);
                if (oldProfesorIdOfAngazovanjeCollectionAngazovanje != null) {
                    oldProfesorIdOfAngazovanjeCollectionAngazovanje.getAngazovanjeCollection().remove(angazovanjeCollectionAngazovanje);
                    oldProfesorIdOfAngazovanjeCollectionAngazovanje = em.merge(oldProfesorIdOfAngazovanjeCollectionAngazovanje);
                }
            }
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            if (findProfesor(profesor.getProfesorId()) != null) {
                throw new PreexistingEntityException("Profesor " + profesor + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Profesor profesor) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Profesor persistentProfesor = em.find(Profesor.class, profesor.getProfesorId());
            Collection<Angazovanje> angazovanjeCollectionOld = persistentProfesor.getAngazovanjeCollection();
            Collection<Angazovanje> angazovanjeCollectionNew = profesor.getAngazovanjeCollection();
            Collection<Angazovanje> attachedAngazovanjeCollectionNew = new ArrayList<Angazovanje>();
            for (Angazovanje angazovanjeCollectionNewAngazovanjeToAttach : angazovanjeCollectionNew) {
                angazovanjeCollectionNewAngazovanjeToAttach = em.getReference(angazovanjeCollectionNewAngazovanjeToAttach.getClass(), angazovanjeCollectionNewAngazovanjeToAttach.getAngazovanjeId());
                attachedAngazovanjeCollectionNew.add(angazovanjeCollectionNewAngazovanjeToAttach);
            }
            angazovanjeCollectionNew = attachedAngazovanjeCollectionNew;
            profesor.setAngazovanjeCollection(angazovanjeCollectionNew);
            profesor = em.merge(profesor);
            for (Angazovanje angazovanjeCollectionOldAngazovanje : angazovanjeCollectionOld) {
                if (!angazovanjeCollectionNew.contains(angazovanjeCollectionOldAngazovanje)) {
                    angazovanjeCollectionOldAngazovanje.setProfesorId(null);
                    angazovanjeCollectionOldAngazovanje = em.merge(angazovanjeCollectionOldAngazovanje);
                }
            }
            for (Angazovanje angazovanjeCollectionNewAngazovanje : angazovanjeCollectionNew) {
                if (!angazovanjeCollectionOld.contains(angazovanjeCollectionNewAngazovanje)) {
                    Profesor oldProfesorIdOfAngazovanjeCollectionNewAngazovanje = angazovanjeCollectionNewAngazovanje.getProfesorId();
                    angazovanjeCollectionNewAngazovanje.setProfesorId(profesor);
                    angazovanjeCollectionNewAngazovanje = em.merge(angazovanjeCollectionNewAngazovanje);
                    if (oldProfesorIdOfAngazovanjeCollectionNewAngazovanje != null && !oldProfesorIdOfAngazovanjeCollectionNewAngazovanje.equals(profesor)) {
                        oldProfesorIdOfAngazovanjeCollectionNewAngazovanje.getAngazovanjeCollection().remove(angazovanjeCollectionNewAngazovanje);
                        oldProfesorIdOfAngazovanjeCollectionNewAngazovanje = em.merge(oldProfesorIdOfAngazovanjeCollectionNewAngazovanje);
                    }
                }
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
                Integer id = profesor.getProfesorId();
                if (findProfesor(id) == null) {
                    throw new NonexistentEntityException("The profesor with id " + id + " no longer exists.");
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
            Profesor profesor;
            try {
                profesor = em.getReference(Profesor.class, id);
                profesor.getProfesorId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The profesor with id " + id + " no longer exists.", enfe);
            }
            Collection<Angazovanje> angazovanjeCollection = profesor.getAngazovanjeCollection();
            for (Angazovanje angazovanjeCollectionAngazovanje : angazovanjeCollection) {
                angazovanjeCollectionAngazovanje.setProfesorId(null);
                angazovanjeCollectionAngazovanje = em.merge(angazovanjeCollectionAngazovanje);
            }
            em.remove(profesor);
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

    public List<Profesor> findProfesorEntities() {
        return findProfesorEntities(true, -1, -1);
    }

    public List<Profesor> findProfesorEntities(int maxResults, int firstResult) {
        return findProfesorEntities(false, maxResults, firstResult);
    }

    private List<Profesor> findProfesorEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Profesor.class));
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

    public Profesor findProfesor(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Profesor.class, id);
        } finally {
            em.close();
        }
    }

    public int getProfesorCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Profesor> rt = cq.from(Profesor.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
