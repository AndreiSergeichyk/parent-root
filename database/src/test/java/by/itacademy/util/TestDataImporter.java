package by.itacademy.util;

import by.itacademy.dao.impl.AuthorDaoImpl;
import by.itacademy.dao.impl.BookDaoImpl;
import by.itacademy.dao.impl.GenreDaoImpl;
import by.itacademy.dao.impl.PublisherDaoImpl;
import by.itacademy.dao.impl.ReviewDaoImpl;
import by.itacademy.dao.impl.RoleDaoImpl;
import by.itacademy.dao.impl.UserBookDaoImpl;
import by.itacademy.dao.impl.UserDaoImpl;
import by.itacademy.dao.impl.VoteDaoImpl;
import by.itacademy.entity.Author;
import by.itacademy.entity.Book;
import by.itacademy.entity.Contact;
import by.itacademy.entity.Genre;
import by.itacademy.entity.Publisher;
import by.itacademy.entity.Review;
import by.itacademy.entity.Role;
import by.itacademy.entity.User;
import by.itacademy.entity.UserBook;
import by.itacademy.entity.Vote;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;

@Component
public class TestDataImporter {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private AuthorDaoImpl authorDao;

    @Autowired
    private BookDaoImpl bookDao;

    @Autowired
    private GenreDaoImpl genreDao;

    @Autowired
    private PublisherDaoImpl publisherDao;

    @Autowired
    private ReviewDaoImpl reviewDao;

    @Autowired
    private RoleDaoImpl roleDao;

    @Autowired
    private UserBookDaoImpl userBookDao;

    @Autowired
    private UserDaoImpl userDao;

    @Autowired
    private VoteDaoImpl voteDao;

    public void importTestData() {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Author authorSecond = saveAuthor(session, "authorSecond");
            Author authorThird = saveAuthor(session, "authorThird");

            Publisher publisherFirst = savePublisher(session, "publisherFirst");
            Publisher publisherSecond = savePublisher(session, "publisherSecond");
            Publisher publisherThird = savePublisher(session, "publisherThird");

            Role admin = saveRole(session, "admin");
            Role user = saveRole(session, "user");

            User petr = saveUser(session, "Petr", "admin", new Contact("1265838", "admin@mail.com"), admin);
            User ivan = saveUser(session, "Ivan", "user", new Contact("2334538", "user@mail.com"), user);

            Genre scientific = saveGenre(session, "Научный");
            Genre comedy = saveGenre(session, "Комедия");

            Book bookFirst = saveBook(session, "Java", scientific, authorThird, publisherFirst, 123, "image", 10, "description");
            Book bookSecond = saveBook(session, "C+", scientific, authorThird, publisherFirst, 223, "image", 10, "description");
            Book bookThird = saveBook(session, "Комедия", comedy, authorSecond, publisherSecond, 444, "image", 10, "description");

            Review reviewFirst = saveReview(session, bookFirst, petr, "good!");
            Review reviewSecond = saveReview(session, bookSecond, ivan, "bad!");
            Review reviewThtid = saveReview(session, bookThird, ivan, "bad!");

            Vote voteFirst = saveVote(session, BigDecimal.valueOf(5), bookFirst);
            Vote voteSecond = saveVote(session, BigDecimal.valueOf(4), bookFirst);
            Vote voteThrid = saveVote(session, BigDecimal.valueOf(3), bookSecond);

            UserBook userBookFirst = saveUserBook(session, petr, bookFirst, LocalDate.now(), LocalDate.now().plusMonths(1));
            UserBook userBookSecond = saveUserBook(session, petr, bookSecond, LocalDate.now(), LocalDate.now().plusMonths(1));
            UserBook userBookThrid = saveUserBook(session, ivan, bookThird, LocalDate.now(), LocalDate.now().plusMonths(1));
            session.getTransaction().commit();
        }
    }

    private Author saveAuthor(Session session, String name) {
        Author author = new Author(name);
        authorDao.save(author);

        return author;
    }

    private Publisher savePublisher(Session session, String name) {
        Publisher publisher = new Publisher(name);
        publisherDao.save(publisher);

        return publisher;
    }

    private Role saveRole(Session session, String name) {
        Role role = new Role(name);
        roleDao.save(role);

        return role;
    }

    private User saveUser(Session session, String name, String password, Contact contact, Role role) {
        User user = new User(name, password, contact, role);
        userDao.save(user);

        return user;
    }

    private Genre saveGenre(Session session, String name) {
        Genre genre = new Genre(name);
        genreDao.save(genre);

        return genre;
    }

    private Book saveBook(Session session, String name, Genre genre, Author author, Publisher publisher,
                          Integer pageCount, String image, Integer numberCopies, String description) {
        Book book = new Book(name, genre, author, publisher, pageCount, image, numberCopies, description);
        bookDao.save(book);

        return book;
    }

    private Review saveReview(Session session, Book book, User user, String textReview) {
        Review review = new Review(book, user, textReview);
        reviewDao.save(review);

        return review;
    }

    private Vote saveVote(Session session, BigDecimal value, Book book) {
        Vote vote = new Vote(value, book);
        voteDao.save(vote);

        return vote;
    }

    private UserBook saveUserBook(Session session, User user, Book book, LocalDate dateIssue, LocalDate dateReturn) {
        UserBook userBook = new UserBook(user, book, dateIssue, dateReturn);
        userBookDao.save(userBook);

        return userBook;
    }
}
