package by.itacademy.dao;

import by.itacademy.dao.impl.BookDaoImpl;
import by.itacademy.entity.Author;
import by.itacademy.entity.Book;
import by.itacademy.entity.Genre;
import by.itacademy.entity.Publisher;
import org.hibernate.Session;
import org.junit.Test;

import java.util.List;

public class BookTest extends BaseTest {

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

    @Test
    public void findByAuthorName() {
        try (Session session = FACTORY.openSession()) {
            List<Book> result = BookDaoImpl.getInstance().findByAuthorName("Petr", 1, 1);
        }
    }

    @Test
    public void findByGenreId() {
        try (Session session = FACTORY.openSession()) {
            List<Book> result = BookDaoImpl.getInstance().findByGenreId(1L, 1, 1);
        }
    }

    @Test
    public void findByLetter() {
        try (Session session = FACTORY.openSession()) {
            List<Book> result = BookDaoImpl.getInstance().findByLetter("J", 1, 1);
        }
    }

    @Test
    public void findByRating() {
        try (Session session = FACTORY.openSession()) {
            List<Book> result = BookDaoImpl.getInstance().findByRating(1, 1);
        }
    }
}
