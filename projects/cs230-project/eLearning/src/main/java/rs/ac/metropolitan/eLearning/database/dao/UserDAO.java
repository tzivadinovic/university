package rs.ac.metropolitan.eLearning.database.dao;

import rs.ac.metropolitan.eLearning.entity.User;

public class UserDAO extends AbstractDAO<User>{
    public UserDAO() {
        super(User.class);
    }
}
