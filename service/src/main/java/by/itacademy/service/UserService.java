package by.itacademy.service;

import by.itacademy.dao.UserDao;
import by.itacademy.entity.User;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserService {

    private static final UserService INSTANCE = new UserService();

    public User getUser() {
        return UserDao.getInstance().getUser();
    }

    public static UserService getInstance() {
        return INSTANCE;
    }
}
