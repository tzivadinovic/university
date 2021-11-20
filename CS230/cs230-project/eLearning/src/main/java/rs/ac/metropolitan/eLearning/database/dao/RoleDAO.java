package rs.ac.metropolitan.eLearning.database.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import rs.ac.metropolitan.eLearning.entity.Role;
import rs.ac.metropolitan.eLearning.util.HibernateUtil;

import javax.transaction.Transactional;

public class RoleDAO extends AbstractDAO<Role> {
    public RoleDAO() {
        super(Role.class);
    }

    @Transactional
    public Role findByName(final String roleName) {
        final String QUERY = "select r from Role r where r.role = :role";
        Role role = null;
        Transaction transaction;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            role = session.createQuery(QUERY, Role.class)
                    .setParameter("role", roleName)
                    .getSingleResult();
            transaction.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return role;

    }
}
