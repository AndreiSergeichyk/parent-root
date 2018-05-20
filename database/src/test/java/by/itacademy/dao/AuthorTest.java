package by.itacademy.dao;

import by.itacademy.dao.impl.AuthorDaoImpl;
import by.itacademy.entity.Author;
import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class AuthorTest extends BaseTest {

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

    @Test
    public void findAll() {
        try (Session session = FACTORY.openSession()) {
            List<Author> result = AuthorDaoImpl.getInstance().findAll(1, 1);
        }
    }
}
