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
import rs.ac.metropolitan.cs230.jpa.entity.Smer;
import rs.ac.metropolitan.cs230.jpa.entity.Overa;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.UserTransaction;
import rs.ac.metropolitan.cs230.jpa.controllers.exceptions.NonexistentEntityException;
import rs.ac.metropolitan.cs230.jpa.controllers.exceptions.PreexistingEntityException;
import rs.ac.metropolitan.cs230.jpa.controllers.exceptions.RollbackFailureException;
import rs.ac.metropolitan.cs230.jpa.entity.Student;

/**
 *
 * @author korisnik
 */
public class StudentJpaController implements Serializable {

    public StudentJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Student student) throws PreexistingEntityException, RollbackFailureException, Exception {
        if (student.getOveraCollection() == null) {
            student.setOveraCollection(new ArrayList<Overa>());
        }
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Smer smerId = student.getSmerId();
            if (smerId != null) {
                smerId = em.getReference(smerId.getClass(), smerId.getSmerId());
                student.setSmerId(smerId);
            }
            Collection<Overa> attachedOveraCollection = new ArrayList<Overa>();
            for (Overa overaCollectionOveraToAttach : student.getOveraCollection()) {
                overaCollectionOveraToAttach = em.getReference(overaCollectionOveraToAttach.getClass(), overaCollectionOveraToAttach.getOveraId());
                attachedOveraCollection.add(overaCollectionOveraToAttach);
            }
            student.setOveraCollection(attachedOveraCollection);
            em.persist(student);
            if (smerId != null) {
                smerId.getStudentCollection().add(student);
                smerId = em.merge(smerId);
            }
            for (Overa overaCollectionOvera : student.getOveraCollection()) {
                Student oldIndeksOfOveraCollectionOvera = overaCollectionOvera.getIndeks();
                overaCollectionOvera.setIndeks(student);
                overaCollectionOvera = em.merge(overaCollectionOvera);
                if (oldIndeksOfOveraCollectionOvera != null) {
                    oldIndeksOfOveraCollectionOvera.getOveraCollection().remove(overaCollectionOvera);
                    oldIndeksOfOveraCollectionOvera = em.merge(oldIndeksOfOveraCollectionOvera);
                }
            }
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            if (findStudent(student.getIndeks()) != null) {
                throw new PreexistingEntityException("Student " + student + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Student student) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Student persistentStudent = em.find(Student.class, student.getIndeks());
            Smer smerIdOld = persistentStudent.getSmerId();
            Smer smerIdNew = student.getSmerId();
            Collection<Overa> overaCollectionOld = persistentStudent.getOveraCollection();
            Collection<Overa> overaCollectionNew = student.getOveraCollection();
            if (smerIdNew != null) {
                smerIdNew = em.getReference(smerIdNew.getClass(), smerIdNew.getSmerId());
                student.setSmerId(smerIdNew);
            }
            Collection<Overa> attachedOveraCollectionNew = new ArrayList<Overa>();
            for (Overa overaCollectionNewOveraToAttach : overaCollectionNew) {
                overaCollectionNewOveraToAttach = em.getReference(overaCollectionNewOveraToAttach.getClass(), overaCollectionNewOveraToAttach.getOveraId());
                attachedOveraCollectionNew.add(overaCollectionNewOveraToAttach);
            }
            overaCollectionNew = attachedOveraCollectionNew;
            student.setOveraCollection(overaCollectionNew);
            student = em.merge(student);
            if (smerIdOld != null && !smerIdOld.equals(smerIdNew)) {
                smerIdOld.getStudentCollection().remove(student);
                smerIdOld = em.merge(smerIdOld);
            }
            if (smerIdNew != null && !smerIdNew.equals(smerIdOld)) {
                smerIdNew.getStudentCollection().add(student);
                smerIdNew = em.merge(smerIdNew);
            }
            for (Overa overaCollectionOldOvera : overaCollectionOld) {
                if (!overaCollectionNew.contains(overaCollectionOldOvera)) {
                    overaCollectionOldOvera.setIndeks(null);
                    overaCollectionOldOvera = em.merge(overaCollectionOldOvera);
                }
            }
            for (Overa overaCollectionNewOvera : overaCollectionNew) {
                if (!overaCollectionOld.contains(overaCollectionNewOvera)) {
                    Student oldIndeksOfOveraCollectionNewOvera = overaCollectionNewOvera.getIndeks();
                    overaCollectionNewOvera.setIndeks(student);
                    overaCollectionNewOvera = em.merge(overaCollectionNewOvera);
                    if (oldIndeksOfOveraCollectionNewOvera != null && !oldIndeksOfOveraCollectionNewOvera.equals(student)) {
                        oldIndeksOfOveraCollectionNewOvera.getOveraCollection().remove(overaCollectionNewOvera);
                        oldIndeksOfOveraCollectionNewOvera = em.merge(oldIndeksOfOveraCollectionNewOvera);
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
                Integer id = student.getIndeks();
                if (findStudent(id) == null) {
                    throw new NonexistentEntityException("The student with id " + id + " no longer exists.");
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
            Student student;
            try {
                student = em.getReference(Student.class, id);
                student.getIndeks();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The student with id " + id + " no longer exists.", enfe);
            }
            Smer smerId = student.getSmerId();
            if (smerId != null) {
                smerId.getStudentCollection().remove(student);
                smerId = em.merge(smerId);
            }
            Collection<Overa> overaCollection = student.getOveraCollection();
            for (Overa overaCollectionOvera : overaCollection) {
                overaCollectionOvera.setIndeks(null);
                overaCollectionOvera = em.merge(overaCollectionOvera);
            }
            em.remove(student);
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

    public List<Student> findStudentEntities() {
        return findStudentEntities(true, -1, -1);
    }

    public List<Student> findStudentEntities(int maxResults, int firstResult) {
        return findStudentEntities(false, maxResults, firstResult);
    }

    private List<Student> findStudentEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Student.class));
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

    public Student findStudent(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Student.class, id);
        } finally {
            em.close();
        }
    }

    public int getStudentCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Student> rt = cq.from(Student.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
