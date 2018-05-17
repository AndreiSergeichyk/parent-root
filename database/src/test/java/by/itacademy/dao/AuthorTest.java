package by.itacademy.dao;

import by.itacademy.entity.Author;
import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;

public class AuthorTest extends BaseTest {

    @Before
    public void clean() {
        try (Session session = FACTORY.openSession()) {
            session.beginTransaction();
            session.createQuery("delete from Author ").executeUpdate();
            session.getTransaction().commit();
        }
    }

    @Test
    public void saveAuthor() {
        Author author = new Author("A.Дюма1");
        save(author);
    }

    @Test
    public void getAuthor() {
        Author author = new Author("A.Дюма2");
        find(author);
    }
}
