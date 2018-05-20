package by.itacademy.dao;

import by.itacademy.dao.impl.BookDaoImpl;
import by.itacademy.dao.impl.VoteDaoImpl;
import by.itacademy.entity.Author;
import by.itacademy.entity.Book;
import by.itacademy.entity.Genre;
import by.itacademy.entity.Publisher;
import by.itacademy.entity.Vote;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

public class VoteTest extends BaseTest {

    @Test
    public void saveVote() {
        Genre genre = new Genre("Художественный17");
        Author author = new Author("А.Дюма17");
        Publisher publisher = new Publisher("Тест17");
        Book book = new Book("Граф Монте-Кристо17", genre, author, publisher,
                617, "image17", 17, "description17");
        Vote vote = new Vote(new BigDecimal(4.7), book);

        save(genre, author, publisher, book, vote);
    }

    @Test
    public void findVote() {
        Genre genre = new Genre("Художественный18");
        Author author = new Author("А.Дюма18");
        Publisher publisher = new Publisher("Тест18");
        Book book = new Book("Граф Монте-Кристо18", genre, author, publisher,
                6418, "image18", 118, "description18");
        Vote vote = new Vote(new BigDecimal(4.7), book);

        find(genre, author, publisher, book, vote);
    }

    @Test
    public void findByBookId() {
        Book book = BookDaoImpl.getInstance().findByName("Java");
        Long bookId = book.getId();
        BigDecimal avgVote = VoteDaoImpl.getInstance().findByBookId(bookId);
        System.out.println();
    }
}
