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
import rs.ac.metropolitan.cs230.jpa.entity.Overa;
import rs.ac.metropolitan.cs230.jpa.entity.Predmet;

/**
 *
 * @author korisnik
 */
public class PredmetJpaController implements Serializable {

    public PredmetJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Predmet predmet) throws PreexistingEntityException, RollbackFailureException, Exception {
        if (predmet.getAngazovanjeCollection() == null) {
            predmet.setAngazovanjeCollection(new ArrayList<Angazovanje>());
        }
        if (predmet.getOveraCollection() == null) {
            predmet.setOveraCollection(new ArrayList<Overa>());
        }
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Collection<Angazovanje> attachedAngazovanjeCollection = new ArrayList<Angazovanje>();
            for (Angazovanje angazovanjeCollectionAngazovanjeToAttach : predmet.getAngazovanjeCollection()) {
                angazovanjeCollectionAngazovanjeToAttach = em.getReference(angazovanjeCollectionAngazovanjeToAttach.getClass(), angazovanjeCollectionAngazovanjeToAttach.getAngazovanjeId());
                attachedAngazovanjeCollection.add(angazovanjeCollectionAngazovanjeToAttach);
            }
            predmet.setAngazovanjeCollection(attachedAngazovanjeCollection);
            Collection<Overa> attachedOveraCollection = new ArrayList<Overa>();
            for (Overa overaCollectionOveraToAttach : predmet.getOveraCollection()) {
                overaCollectionOveraToAttach = em.getReference(overaCollectionOveraToAttach.getClass(), overaCollectionOveraToAttach.getOveraId());
                attachedOveraCollection.add(overaCollectionOveraToAttach);
            }
            predmet.setOveraCollection(attachedOveraCollection);
            em.persist(predmet);
            for (Angazovanje angazovanjeCollectionAngazovanje : predmet.getAngazovanjeCollection()) {
                Predmet oldPredmetIdOfAngazovanjeCollectionAngazovanje = angazovanjeCollectionAngazovanje.getPredmetId();
                angazovanjeCollectionAngazovanje.setPredmetId(predmet);
                angazovanjeCollectionAngazovanje = em.merge(angazovanjeCollectionAngazovanje);
                if (oldPredmetIdOfAngazovanjeCollectionAngazovanje != null) {
                    oldPredmetIdOfAngazovanjeCollectionAngazovanje.getAngazovanjeCollection().remove(angazovanjeCollectionAngazovanje);
                    oldPredmetIdOfAngazovanjeCollectionAngazovanje = em.merge(oldPredmetIdOfAngazovanjeCollectionAngazovanje);
                }
            }
            for (Overa overaCollectionOvera : predmet.getOveraCollection()) {
                Predmet oldPredmetIdOfOveraCollectionOvera = overaCollectionOvera.getPredmetId();
                overaCollectionOvera.setPredmetId(predmet);
                overaCollectionOvera = em.merge(overaCollectionOvera);
                if (oldPredmetIdOfOveraCollectionOvera != null) {
                    oldPredmetIdOfOveraCollectionOvera.getOveraCollection().remove(overaCollectionOvera);
                    oldPredmetIdOfOveraCollectionOvera = em.merge(oldPredmetIdOfOveraCollectionOvera);
                }
            }
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            if (findPredmet(predmet.getPredmetId()) != null) {
                throw new PreexistingEntityException("Predmet " + predmet + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Predmet predmet) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Predmet persistentPredmet = em.find(Predmet.class, predmet.getPredmetId());
            Collection<Angazovanje> angazovanjeCollectionOld = persistentPredmet.getAngazovanjeCollection();
            Collection<Angazovanje> angazovanjeCollectionNew = predmet.getAngazovanjeCollection();
            Collection<Overa> overaCollectionOld = persistentPredmet.getOveraCollection();
            Collection<Overa> overaCollectionNew = predmet.getOveraCollection();
            Collection<Angazovanje> attachedAngazovanjeCollectionNew = new ArrayList<Angazovanje>();
            for (Angazovanje angazovanjeCollectionNewAngazovanjeToAttach : angazovanjeCollectionNew) {
                angazovanjeCollectionNewAngazovanjeToAttach = em.getReference(angazovanjeCollectionNewAngazovanjeToAttach.getClass(), angazovanjeCollectionNewAngazovanjeToAttach.getAngazovanjeId());
                attachedAngazovanjeCollectionNew.add(angazovanjeCollectionNewAngazovanjeToAttach);
            }
            angazovanjeCollectionNew = attachedAngazovanjeCollectionNew;
            predmet.setAngazovanjeCollection(angazovanjeCollectionNew);
            Collection<Overa> attachedOveraCollectionNew = new ArrayList<Overa>();
            for (Overa overaCollectionNewOveraToAttach : overaCollectionNew) {
                overaCollectionNewOveraToAttach = em.getReference(overaCollectionNewOveraToAttach.getClass(), overaCollectionNewOveraToAttach.getOveraId());
                attachedOveraCollectionNew.add(overaCollectionNewOveraToAttach);
            }
            overaCollectionNew = attachedOveraCollectionNew;
            predmet.setOveraCollection(overaCollectionNew);
            predmet = em.merge(predmet);
            for (Angazovanje angazovanjeCollectionOldAngazovanje : angazovanjeCollectionOld) {
                if (!angazovanjeCollectionNew.contains(angazovanjeCollectionOldAngazovanje)) {
                    angazovanjeCollectionOldAngazovanje.setPredmetId(null);
                    angazovanjeCollectionOldAngazovanje = em.merge(angazovanjeCollectionOldAngazovanje);
                }
            }
            for (Angazovanje angazovanjeCollectionNewAngazovanje : angazovanjeCollectionNew) {
                if (!angazovanjeCollectionOld.contains(angazovanjeCollectionNewAngazovanje)) {
                    Predmet oldPredmetIdOfAngazovanjeCollectionNewAngazovanje = angazovanjeCollectionNewAngazovanje.getPredmetId();
                    angazovanjeCollectionNewAngazovanje.setPredmetId(predmet);
                    angazovanjeCollectionNewAngazovanje = em.merge(angazovanjeCollectionNewAngazovanje);
                    if (oldPredmetIdOfAngazovanjeCollectionNewAngazovanje != null && !oldPredmetIdOfAngazovanjeCollectionNewAngazovanje.equals(predmet)) {
                        oldPredmetIdOfAngazovanjeCollectionNewAngazovanje.getAngazovanjeCollection().remove(angazovanjeCollectionNewAngazovanje);
                        oldPredmetIdOfAngazovanjeCollectionNewAngazovanje = em.merge(oldPredmetIdOfAngazovanjeCollectionNewAngazovanje);
                    }
                }
            }
            for (Overa overaCollectionOldOvera : overaCollectionOld) {
                if (!overaCollectionNew.contains(overaCollectionOldOvera)) {
                    overaCollectionOldOvera.setPredmetId(null);
                    overaCollectionOldOvera = em.merge(overaCollectionOldOvera);
                }
            }
            for (Overa overaCollectionNewOvera : overaCollectionNew) {
                if (!overaCollectionOld.contains(overaCollectionNewOvera)) {
                    Predmet oldPredmetIdOfOveraCollectionNewOvera = overaCollectionNewOvera.getPredmetId();
                    overaCollectionNewOvera.setPredmetId(predmet);
                    overaCollectionNewOvera = em.merge(overaCollectionNewOvera);
                    if (oldPredmetIdOfOveraCollectionNewOvera != null && !oldPredmetIdOfOveraCollectionNewOvera.equals(predmet)) {
                        oldPredmetIdOfOveraCollectionNewOvera.getOveraCollection().remove(overaCollectionNewOvera);
                        oldPredmetIdOfOveraCollectionNewOvera = em.merge(oldPredmetIdOfOveraCollectionNewOvera);
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
                String id = predmet.getPredmetId();
                if (findPredmet(id) == null) {
                    throw new NonexistentEntityException("The predmet with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Predmet predmet;
            try {
                predmet = em.getReference(Predmet.class, id);
                predmet.getPredmetId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The predmet with id " + id + " no longer exists.", enfe);
            }
            Collection<Angazovanje> angazovanjeCollection = predmet.getAngazovanjeCollection();
            for (Angazovanje angazovanjeCollectionAngazovanje : angazovanjeCollection) {
                angazovanjeCollectionAngazovanje.setPredmetId(null);
                angazovanjeCollectionAngazovanje = em.merge(angazovanjeCollectionAngazovanje);
            }
            Collection<Overa> overaCollection = predmet.getOveraCollection();
            for (Overa overaCollectionOvera : overaCollection) {
                overaCollectionOvera.setPredmetId(null);
                overaCollectionOvera = em.merge(overaCollectionOvera);
            }
            em.remove(predmet);
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

    public List<Predmet> findPredmetEntities() {
        return findPredmetEntities(true, -1, -1);
    }

    public List<Predmet> findPredmetEntities(int maxResults, int firstResult) {
        return findPredmetEntities(false, maxResults, firstResult);
    }

    private List<Predmet> findPredmetEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Predmet.class));
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

    public Predmet findPredmet(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Predmet.class, id);
        } finally {
            em.close();
        }
    }

    public int getPredmetCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Predmet> rt = cq.from(Predmet.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
