package by.itacademy.dao;

import by.itacademy.dao.impl.AuthorDaoImpl;
import by.itacademy.dao.impl.BookDaoImpl;
import by.itacademy.dao.impl.GenreDaoImpl;
import by.itacademy.dao.impl.PublisherDaoImpl;
import by.itacademy.dao.impl.ReviewDaoImpl;
import by.itacademy.dao.impl.RoleDaoImpl;
import by.itacademy.dao.impl.UserDaoImpl;
import by.itacademy.entity.Author;
import by.itacademy.entity.Book;
import by.itacademy.entity.Contact;
import by.itacademy.entity.Genre;
import by.itacademy.entity.Publisher;
import by.itacademy.entity.Review;
import by.itacademy.entity.Role;
import by.itacademy.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

public class ReviewTest extends BaseTest {

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
    private ReviewDaoImpl reviewDao;

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
        Long reviewId = reviewDao.save(review);
        Assert.assertNotNull("Id is null", reviewId);
    }

    @Test
    public void findReview() {
        List<Review> reviews = reviewDao.findAll();
        assertThat(reviews, hasSize(3));
        Review review = reviews.get(0);
        review = reviewDao.findById(review.getId());
        System.out.println();
        Assert.assertThat(review.getTextReview(), equalTo("good!"));
    }

    @Test
    public void findByBookId() {
        Book book = bookDao.findByName("Java");
        Assert.assertNotNull("Entity is null", book);
        Long bookId = book.getId();
        List<Review> results = reviewDao.findByBookId(bookId);
        assertThat(results, hasSize(1));
    }
}
