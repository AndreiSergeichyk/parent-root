package by.itacademy.dao;

import by.itacademy.dao.impl.AuthorDaoImpl;
import by.itacademy.dao.impl.BookDaoImpl;
import by.itacademy.dao.impl.GenreDaoImpl;
import by.itacademy.dao.impl.PublisherDaoImpl;
import by.itacademy.dao.impl.RoleDaoImpl;
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
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

public class UserBookTest extends BaseTest {

    @Autowired
    private AuthorDaoImpl authorDao;

    @Autowired
    private PublisherDaoImpl publisherDao;

    @Autowired
    private BookDaoImpl bookDao;

    @Autowired
    private GenreDaoImpl genreDao;

    @Autowired
    private RoleDaoImpl roleDao;

    @Autowired
    private UserDaoImpl userDao;

    @Autowired
    private UserBookDaoImpl userBookDao;

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

        Long genreId = genreDao.save(genre);
        Assert.assertNotNull("Id is null", genreId);
        Long authorId = authorDao.save(author);
        Assert.assertNotNull("Id is null", authorId);
        Long publisherId = publisherDao.save(publisher);
        Assert.assertNotNull("Id is null", publisherId);
        Long bookId = bookDao.save(book);
        Assert.assertNotNull("Id is null", bookId);
        Integer roleId = roleDao.save(role);
        Assert.assertNotNull("Id is null", roleId);
        Long userId = userDao.save(user);
        Assert.assertNotNull("Id is null", userId);
        Long userBookId = userBookDao.save(userBook);
        Assert.assertNotNull("Id is null", userBookId);
    }

    @Test
    public void findUserBook() {
        List<UserBook> userBooks = userBookDao.findAll();
        assertThat(userBooks, hasSize(3));
        UserBook userBook = userBooks.get(0);
        userBooks = userBookDao.findByUserId(userBook.getUser().getId());
        assertThat(userBooks, hasSize(2));
    }

    @Test
    public void findByUserId() {
        User user = userDao.findByNameAndPassword("Petr", "admin");
        Assert.assertNotNull("Entity is null", user);
        List<UserBook> results = userBookDao.findByUserId(user.getId());
        System.out.println();
        assertThat(results, hasSize(2));
    }

    @Test
    public void save() {
        User user = userDao.findByNameAndPassword("Petr", "admin");
        Assert.assertNotNull("Entity is null", user);
        List<UserBook> results = userBookDao.findByUserId(user.getId());
        assertThat(results, hasSize(2));
        UserBook userBook = results.get(0);
        userBookDao.save(userBook);

        List<UserBook> secondResults = userBookDao.findByUserId(user.getId());
        assertThat(secondResults, hasSize(3));
    }
}
