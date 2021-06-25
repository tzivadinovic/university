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
import rs.ac.metropolitan.cs230.jpa.entity.Student;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.UserTransaction;
import rs.ac.metropolitan.cs230.jpa.controllers.exceptions.NonexistentEntityException;
import rs.ac.metropolitan.cs230.jpa.controllers.exceptions.PreexistingEntityException;
import rs.ac.metropolitan.cs230.jpa.controllers.exceptions.RollbackFailureException;
import rs.ac.metropolitan.cs230.jpa.entity.Smer;

/**
 *
 * @author korisnik
 */
public class SmerJpaController implements Serializable {

    public SmerJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Smer smer) throws PreexistingEntityException, RollbackFailureException, Exception {
        if (smer.getStudentCollection() == null) {
            smer.setStudentCollection(new ArrayList<Student>());
        }
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Collection<Student> attachedStudentCollection = new ArrayList<Student>();
            for (Student studentCollectionStudentToAttach : smer.getStudentCollection()) {
                studentCollectionStudentToAttach = em.getReference(studentCollectionStudentToAttach.getClass(), studentCollectionStudentToAttach.getIndeks());
                attachedStudentCollection.add(studentCollectionStudentToAttach);
            }
            smer.setStudentCollection(attachedStudentCollection);
            em.persist(smer);
            for (Student studentCollectionStudent : smer.getStudentCollection()) {
                Smer oldSmerIdOfStudentCollectionStudent = studentCollectionStudent.getSmerId();
                studentCollectionStudent.setSmerId(smer);
                studentCollectionStudent = em.merge(studentCollectionStudent);
                if (oldSmerIdOfStudentCollectionStudent != null) {
                    oldSmerIdOfStudentCollectionStudent.getStudentCollection().remove(studentCollectionStudent);
                    oldSmerIdOfStudentCollectionStudent = em.merge(oldSmerIdOfStudentCollectionStudent);
                }
            }
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            if (findSmer(smer.getSmerId()) != null) {
                throw new PreexistingEntityException("Smer " + smer + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Smer smer) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Smer persistentSmer = em.find(Smer.class, smer.getSmerId());
            Collection<Student> studentCollectionOld = persistentSmer.getStudentCollection();
            Collection<Student> studentCollectionNew = smer.getStudentCollection();
            Collection<Student> attachedStudentCollectionNew = new ArrayList<Student>();
            for (Student studentCollectionNewStudentToAttach : studentCollectionNew) {
                studentCollectionNewStudentToAttach = em.getReference(studentCollectionNewStudentToAttach.getClass(), studentCollectionNewStudentToAttach.getIndeks());
                attachedStudentCollectionNew.add(studentCollectionNewStudentToAttach);
            }
            studentCollectionNew = attachedStudentCollectionNew;
            smer.setStudentCollection(studentCollectionNew);
            smer = em.merge(smer);
            for (Student studentCollectionOldStudent : studentCollectionOld) {
                if (!studentCollectionNew.contains(studentCollectionOldStudent)) {
                    studentCollectionOldStudent.setSmerId(null);
                    studentCollectionOldStudent = em.merge(studentCollectionOldStudent);
                }
            }
            for (Student studentCollectionNewStudent : studentCollectionNew) {
                if (!studentCollectionOld.contains(studentCollectionNewStudent)) {
                    Smer oldSmerIdOfStudentCollectionNewStudent = studentCollectionNewStudent.getSmerId();
                    studentCollectionNewStudent.setSmerId(smer);
                    studentCollectionNewStudent = em.merge(studentCollectionNewStudent);
                    if (oldSmerIdOfStudentCollectionNewStudent != null && !oldSmerIdOfStudentCollectionNewStudent.equals(smer)) {
                        oldSmerIdOfStudentCollectionNewStudent.getStudentCollection().remove(studentCollectionNewStudent);
                        oldSmerIdOfStudentCollectionNewStudent = em.merge(oldSmerIdOfStudentCollectionNewStudent);
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
                Integer id = smer.getSmerId();
                if (findSmer(id) == null) {
                    throw new NonexistentEntityException("The smer with id " + id + " no longer exists.");
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
            Smer smer;
            try {
                smer = em.getReference(Smer.class, id);
                smer.getSmerId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The smer with id " + id + " no longer exists.", enfe);
            }
            Collection<Student> studentCollection = smer.getStudentCollection();
            for (Student studentCollectionStudent : studentCollection) {
                studentCollectionStudent.setSmerId(null);
                studentCollectionStudent = em.merge(studentCollectionStudent);
            }
            em.remove(smer);
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

    public List<Smer> findSmerEntities() {
        return findSmerEntities(true, -1, -1);
    }

    public List<Smer> findSmerEntities(int maxResults, int firstResult) {
        return findSmerEntities(false, maxResults, firstResult);
    }

    private List<Smer> findSmerEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Smer.class));
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

    public Smer findSmer(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Smer.class, id);
        } finally {
            em.close();
        }
    }

    public int getSmerCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Smer> rt = cq.from(Smer.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
