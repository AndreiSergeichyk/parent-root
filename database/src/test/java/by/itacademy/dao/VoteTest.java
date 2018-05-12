package by.itacademy.dao;

import by.itacademy.entity.Author;
import by.itacademy.entity.Book;
import by.itacademy.entity.Genre;
import by.itacademy.entity.Publisher;
import by.itacademy.entity.Vote;
import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;

public class VoteTest extends BaseTest {

    @Before
    public void clean() {
        try (Session session = FACTORY.openSession()) {
            session.beginTransaction();
            session.createQuery("delete from Vote ").executeUpdate();
            session.createQuery("delete from Book ").executeUpdate();
            session.createQuery("delete from Author ").executeUpdate();
            session.createQuery("delete from Publisher ").executeUpdate();
            session.createQuery("delete from Genre ").executeUpdate();
            session.getTransaction().commit();
        }
    }

    @Test
    public void saveVote() {
        Genre genre = new Genre("Художественный17");
        Author author = new Author("А.Дюма17");
        Publisher publisher = new Publisher("Тест17");
        Book book = new Book("Граф Монте-Кристо17", genre, author, publisher,
                617, "image17", 17, "description17");
        Vote vote = new Vote(4.17, book);

        save(genre, author, publisher, book, vote);
    }

    @Test
    public void findVote() {
        Genre genre = new Genre("Художественный18");
        Author author = new Author("А.Дюма18");
        Publisher publisher = new Publisher("Тест18");
        Book book = new Book("Граф Монте-Кристо18", genre, author, publisher,
                6418, "image18", 118, "description18");
        Vote vote = new Vote(4.18, book);

        find(genre, author, publisher, book, vote);
    }
}
