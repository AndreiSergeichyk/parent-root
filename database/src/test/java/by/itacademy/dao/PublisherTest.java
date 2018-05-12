package by.itacademy.dao;

import by.itacademy.entity.Publisher;
import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;

public class PublisherTest extends BaseTest {

    @Before
    public void clean() {
        try (Session session = FACTORY.openSession()) {
            session.beginTransaction();
            session.createQuery("delete from Publisher ").executeUpdate();
            session.getTransaction().commit();
        }
    }

    @Test
    public void savePublisher() {
        Publisher publisher = new Publisher("Тест7");
        save(publisher);
    }

    @Test
    public void findPublisher() {
        Publisher publisher = new Publisher("Тест8");
        find(publisher);
    }
}
