package by.itacademy.dao;

import by.itacademy.dao.impl.BookDaoImpl;
import by.itacademy.dao.impl.ReviewDaoImpl;
import by.itacademy.entity.Author;
import by.itacademy.entity.Book;
import by.itacademy.entity.Contact;
import by.itacademy.entity.Genre;
import by.itacademy.entity.Publisher;
import by.itacademy.entity.Review;
import by.itacademy.entity.Role;
import by.itacademy.entity.User;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

public class ReviewTest extends BaseTest {

    @Test
    public void saveReview() {
        Genre genre = new Genre("Художественный9");
        Author author = new Author("А.Дюма9");
        Publisher publisher = new Publisher("Тест9");
        Book book = new Book("Граф Монте- Кристо9", genre, author, publisher,
                645, "image9", 139, "description9");
        Role role = new Role("admin9");
        User user = new User("Andrei9", "admin9",
                new Contact("123456789", "qwerty@mail.com9"), role);
        Review review = new Review(book, user, "Книга очень интересная9!");

        save(genre, author, publisher, book, role, user, review);
    }

    @Test
    public void findReview() {
        Genre genre = new Genre("Художественный0");
        Author author = new Author("А.Дюма0");
        Publisher publisher = new Publisher("Тест0");
        Book book = new Book("Граф Монте-Кристо0", genre, author, publisher,
                645, "image0", 130, "description0");
        Role role = new Role("admin0");
        User user = new User("Andrei0", "admin0",
                new Contact("123456780", "qwerty@mail.com0"), role);
        Review review = new Review(book, user, "Книга очень интересная0!");

        find(genre, author, publisher, book, role, user, review);
    }

    @Test
    public void findByBookId() {
        Book book = BookDaoImpl.getInstance().findByName("Java");
        Long bookId = book.getId();
        List<Review> results = ReviewDaoImpl.getInstance().findByBookId(bookId);
        assertThat(results, hasSize(1));
    }
}
