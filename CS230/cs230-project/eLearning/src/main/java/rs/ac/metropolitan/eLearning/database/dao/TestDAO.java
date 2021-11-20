package rs.ac.metropolitan.eLearning.database.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import rs.ac.metropolitan.eLearning.entity.Test;
import rs.ac.metropolitan.eLearning.util.HibernateUtil;

import javax.transaction.Transactional;

public class TestDAO extends AbstractDAO<Test> {
    public TestDAO() {
        super(Test.class);
    }

    @Transactional
    public Test findByName(final String testName) {
        final String QUERY = "select t from Test t where t.title = :test";
        Test test = null;
        Transaction transaction;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            test = session.createQuery(QUERY, Test.class)
                    .setParameter("test", testName)
                    .getSingleResult();
            transaction.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return test;

    }
}
