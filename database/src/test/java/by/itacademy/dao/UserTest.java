package by.itacademy.dao;

import by.itacademy.entity.Contacts;
import by.itacademy.entity.Role;
import by.itacademy.entity.User;
import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;

public class UserTest extends BaseTest {

    @Before
    public void clean() {
        try (Session session = FACTORY.openSession()) {
            session.beginTransaction();
            session.createQuery("delete from User ").executeUpdate();
            session.createQuery("delete from Role ").executeUpdate();
            session.getTransaction().commit();
        }
    }

    @Test
    public void saveUser() {
        Role role = new Role("admin15");
        User user = new User("Andrei15", "admin15",
                new Contacts("12345615", "qwerty@mail.com15"), role);
        save(role, user);
    }

    @Test
    public void findUser() {
        Role role = new Role("admin16");
        User user = new User("Andrei16", "admin16",
                new Contacts("1234567816", "qwerty@mail.com16"), role);
        find(role, user);
    }
}
