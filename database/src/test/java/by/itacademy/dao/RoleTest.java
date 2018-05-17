package by.itacademy.dao;

import by.itacademy.entity.Role;
import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;

public class RoleTest extends BaseTest {

    @Before
    public void clean() {
        try (Session session = FACTORY.openSession()) {
            session.beginTransaction();
            session.createQuery("delete from Role ").executeUpdate();
            session.getTransaction().commit();
        }
    }

    @Test
    public void saveRole() {
        Role role = new Role("admin11");
        save(role);
    }

    @Test
    public void findRole() {
        Role role = new Role("admin12");
        find(role);
    }
}
