package by.itacademy.dao.impl;

import by.itacademy.dao.interfaces.UserDao;
import by.itacademy.entity.User;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.hibernate.Session;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserDaoImpl extends BaseDao<Long, User> implements UserDao {

    private static final UserDaoImpl INSTANCE = new UserDaoImpl();

    @Override
    public User findByNameAndPassword(String name, String password) {
        try (Session session = SESSION_FACTORY.openSession()) {
            return session.createQuery("select u from User u " +
                    "where u.name = :name and u.password = :password", User.class)
                    .setParameter("name", name)
                    .setParameter("password", password)
                    .getSingleResult();
        }
    }

    public static UserDaoImpl getInstance() {
        return INSTANCE;
    }
}
