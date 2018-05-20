package by.itacademy.dao;

import by.itacademy.dao.impl.UserBookDaoImpl;
import by.itacademy.dao.impl.UserDaoImpl;
import by.itacademy.entity.Author;
import by.itacademy.entity.Book;
import by.itacademy.entity.Contact;
import by.itacademy.entity.Genre;
import by.itacademy.entity.Publisher;
import by.itacademy.entity.Role;
import by.itacademy.entity.User;
import by.itacademy.entity.UserBook;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

public class UserBookTest extends BaseTest {

    @Test
    public void saveUserBook() {
        Role role = new Role("Боевик13");
        User user = new User("admin31", "admin13",
                new Contact("1234513", "admin@mail.ru13"), role);
        Genre genre = new Genre("Художественный13");
        Author author = new Author("А.Дюма13");
        Publisher publisher = new Publisher("Тест13");
        Book book = new Book("Граф Монте-Кристо13", genre, author, publisher,
                6452, "image13", 113, "description13");
        UserBook userBook = new UserBook(user, book, LocalDate.now(), LocalDate.now());

        save(role, user, genre, author, publisher, book, userBook);
    }

    @Test
    public void findUserBook() {
        Role role = new Role("Боевик14");
        User user = new User("admin14", "admin14",
                new Contact("123414", "admin@mail.ru14"), role);
        Genre genre = new Genre("Художественный14");
        Author author = new Author("А.Дюма14");
        Publisher publisher = new Publisher("Тест14");
        Book book = new Book("Граф Монте-Кристо14", genre, author, publisher,
                614, "image14", 1314, "description14");
        UserBook userBook = new UserBook(user, book, LocalDate.now(), LocalDate.now());

        find(role, user, genre, author, publisher, book, userBook);
    }

    @Test
    public void findByUserId() {
        User user = UserDaoImpl.getInstance().findByNameAndPassword("Petr", "admin");
        List<UserBook> results = UserBookDaoImpl.getInstance().findByUserId(user.getId());
        assertThat(results, hasSize(2));
    }

    @Test
    public void save() {
        User user = UserDaoImpl.getInstance().findByNameAndPassword("Petr", "admin");
        List<UserBook> results = UserBookDaoImpl.getInstance().findByUserId(user.getId());
        UserBook userBook = results.get(0);
        UserBookDaoImpl.getInstance().save(userBook);

        List<UserBook> secondResults = UserBookDaoImpl.getInstance().findByUserId(user.getId());
        assertThat(secondResults, hasSize(3));
    }
}
