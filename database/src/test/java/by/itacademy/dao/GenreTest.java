package by.itacademy.dao;

import by.itacademy.entity.Genre;
import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;

public class GenreTest extends BaseTest {

    @Before
    public void clean() {
        try (Session session = FACTORY.openSession()) {
            session.beginTransaction();
            session.createQuery("delete from Genre ").executeUpdate();
            session.getTransaction().commit();
        }
    }

    @Test
    public void saveGenre() {
        Genre genre = new Genre("Боевик5");
        save(genre);
    }

    @Test
    public void findGenre() {
        Genre genre = new Genre("Боевик6");
        find(genre);
    }
}
