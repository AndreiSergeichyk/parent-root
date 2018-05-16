package by.itacademy.dao;

import by.itacademy.entity.User;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserDao {

    private static final UserDao INSTANCE = new UserDao();
    private static final SessionFactory FACTORY = new Configuration().configure().buildSessionFactory();

    public User getUser(Long id) {
        User user;
        try (Session session = FACTORY.openSession();) {
            session.beginTransaction();

            user = session.get(User.class, id);

            session.getTransaction().commit();
        }

        return user;
    }

    public static UserDao getInstance() {
        return INSTANCE;
    }
}
