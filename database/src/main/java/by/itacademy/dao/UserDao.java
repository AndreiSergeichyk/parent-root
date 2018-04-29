package by.itacademy.dao;

import by.itacademy.entity.User;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserDao {

    private static final UserDao INSTANCE = new UserDao();

    public User getUser() {
        return new User(1L, "Andrey");
    }

    public static UserDao getInstance() {
        return INSTANCE;
    }
}
