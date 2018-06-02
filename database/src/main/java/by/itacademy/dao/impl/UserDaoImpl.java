package by.itacademy.dao.impl;

import by.itacademy.dao.interfaces.UserDao;
import by.itacademy.entity.User;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Repository
public class UserDaoImpl extends BaseDao<Long, User> implements UserDao {

    @Override
    public User findByNameAndPassword(String name, String password) {
        return sessionFactory.getCurrentSession().createQuery("select u from User u " +
                "where u.name = :name and u.password = :password", User.class)
                .setParameter("name", name)
                .setParameter("password", password)
                .getSingleResult();
    }
}
