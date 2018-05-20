package by.itacademy.service;

import by.itacademy.dao.impl.UserDaoImpl;
import by.itacademy.entity.User;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserService {

    private static final UserService INSTANCE = new UserService();

    public User getUser(Long id) {
        return null;
    }

    public static UserService getInstance() {
        return INSTANCE;
    }
}
