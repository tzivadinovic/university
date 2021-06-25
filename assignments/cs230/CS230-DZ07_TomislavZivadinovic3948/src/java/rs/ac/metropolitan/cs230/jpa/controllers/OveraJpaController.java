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
import rs.ac.metropolitan.cs230.jpa.entity.Overa;
import rs.ac.metropolitan.cs230.jpa.entity.Student;
import rs.ac.metropolitan.cs230.jpa.entity.Predmet;

/**
 *
 * @author korisnik
 */
public class OveraJpaController implements Serializable {

    public OveraJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Overa overa) throws PreexistingEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Student indeks = overa.getIndeks();
            if (indeks != null) {
                indeks = em.getReference(indeks.getClass(), indeks.getIndeks());
                overa.setIndeks(indeks);
            }
            Predmet predmetId = overa.getPredmetId();
            if (predmetId != null) {
                predmetId = em.getReference(predmetId.getClass(), predmetId.getPredmetId());
                overa.setPredmetId(predmetId);
            }
            em.persist(overa);
            if (indeks != null) {
                indeks.getOveraCollection().add(overa);
                indeks = em.merge(indeks);
            }
            if (predmetId != null) {
                predmetId.getOveraCollection().add(overa);
                predmetId = em.merge(predmetId);
            }
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            if (findOvera(overa.getOveraId()) != null) {
                throw new PreexistingEntityException("Overa " + overa + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Overa overa) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Overa persistentOvera = em.find(Overa.class, overa.getOveraId());
            Student indeksOld = persistentOvera.getIndeks();
            Student indeksNew = overa.getIndeks();
            Predmet predmetIdOld = persistentOvera.getPredmetId();
            Predmet predmetIdNew = overa.getPredmetId();
            if (indeksNew != null) {
                indeksNew = em.getReference(indeksNew.getClass(), indeksNew.getIndeks());
                overa.setIndeks(indeksNew);
            }
            if (predmetIdNew != null) {
                predmetIdNew = em.getReference(predmetIdNew.getClass(), predmetIdNew.getPredmetId());
                overa.setPredmetId(predmetIdNew);
            }
            overa = em.merge(overa);
            if (indeksOld != null && !indeksOld.equals(indeksNew)) {
                indeksOld.getOveraCollection().remove(overa);
                indeksOld = em.merge(indeksOld);
            }
            if (indeksNew != null && !indeksNew.equals(indeksOld)) {
                indeksNew.getOveraCollection().add(overa);
                indeksNew = em.merge(indeksNew);
            }
            if (predmetIdOld != null && !predmetIdOld.equals(predmetIdNew)) {
                predmetIdOld.getOveraCollection().remove(overa);
                predmetIdOld = em.merge(predmetIdOld);
            }
            if (predmetIdNew != null && !predmetIdNew.equals(predmetIdOld)) {
                predmetIdNew.getOveraCollection().add(overa);
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
                Integer id = overa.getOveraId();
                if (findOvera(id) == null) {
                    throw new NonexistentEntityException("The overa with id " + id + " no longer exists.");
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
            Overa overa;
            try {
                overa = em.getReference(Overa.class, id);
                overa.getOveraId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The overa with id " + id + " no longer exists.", enfe);
            }
            Student indeks = overa.getIndeks();
            if (indeks != null) {
                indeks.getOveraCollection().remove(overa);
                indeks = em.merge(indeks);
            }
            Predmet predmetId = overa.getPredmetId();
            if (predmetId != null) {
                predmetId.getOveraCollection().remove(overa);
                predmetId = em.merge(predmetId);
            }
            em.remove(overa);
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

    public List<Overa> findOveraEntities() {
        return findOveraEntities(true, -1, -1);
    }

    public List<Overa> findOveraEntities(int maxResults, int firstResult) {
        return findOveraEntities(false, maxResults, firstResult);
    }

    private List<Overa> findOveraEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Overa.class));
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

    public Overa findOvera(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Overa.class, id);
        } finally {
            em.close();
        }
    }

    public int getOveraCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Overa> rt = cq.from(Overa.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
