package by.itacademy.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestDataDelete {

    @Autowired
    private SessionFactory sessionFactory;

    public void deleteTestData() {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.createQuery("delete from UserBook ").executeUpdate();
            session.createQuery("delete from Vote ").executeUpdate();
            session.createQuery("delete from Review ").executeUpdate();
            session.createQuery("delete from Book ").executeUpdate();
            session.createQuery("delete from User ").executeUpdate();
            session.createQuery("delete from Role ").executeUpdate();
            session.createQuery("delete from Genre ").executeUpdate();
            session.createQuery("delete from Author ").executeUpdate();
            session.createQuery("delete from Publisher ").executeUpdate();

            session.getTransaction().commit();
        }
    }
}
