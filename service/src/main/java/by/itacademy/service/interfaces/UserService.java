package by.itacademy.service.interfaces;

import by.itacademy.entity.User;

public interface UserService extends ServiceInt<Long, User> {

    User findByNameAndPassword(String userName, String pasword);
}
