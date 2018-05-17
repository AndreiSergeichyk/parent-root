package by.itacademy.dao;

import by.itacademy.entity.Author;
import by.itacademy.entity.Book;
import by.itacademy.entity.Genre;
import by.itacademy.entity.Publisher;
import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;

public class BookTest extends BaseTest {

    @Before
    public void clean() {
        try (Session session = FACTORY.openSession()) {
            session.beginTransaction();
            session.createQuery("delete from Book ").executeUpdate();
            session.createQuery("delete from Genre ").executeUpdate();
            session.createQuery("delete from Author ").executeUpdate();
            session.createQuery("delete from Publisher ").executeUpdate();
            session.getTransaction().commit();
        }
    }

    @Test
    public void saveBook() {
        Genre genre = new Genre("Художественный3");
        Author author = new Author("А.Дюма3");
        Publisher publisher = new Publisher("Тест3");
        Book book = new Book("Граф Монте-Кристо3", genre, author, publisher,
                643, "image3", 133, "description3");

        save(genre, author, publisher, book);
    }

    @Test
    public void findBook() {
        Genre genre = new Genre("Художественный4");
        Author author = new Author("А.Дюма4");
        Publisher publisher = new Publisher("Тест4");
        Book book = new Book("Граф Монте-Кристо4", genre, author, publisher,
                6454, "image4", 134, "description4");

        find(genre, author, publisher, book);
    }
}
