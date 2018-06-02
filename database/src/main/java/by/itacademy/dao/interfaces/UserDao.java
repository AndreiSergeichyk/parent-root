package by.itacademy.dao.interfaces;

import by.itacademy.entity.User;

public interface UserDao extends Dao<Long, User> {

    User findByNameAndPassword(String name, String password);
}
