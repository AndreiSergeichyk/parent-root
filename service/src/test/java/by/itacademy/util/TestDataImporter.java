package by.itacademy.util;

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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.math.BigDecimal;
import java.time.LocalDate;

@Component
public class TestDataImporter {

    private final EntityManagerFactory entityManagerFactory;

    @Autowired
    public TestDataImporter(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    public void importTestData() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Author authorSecond = new Author("authorSecond");
        Author authorThird = new Author("authorThird");
        entityManager.persist(authorSecond);
        entityManager.persist(authorThird);

        Publisher publisherFirst = new Publisher("publisherFirst");
        Publisher publisherSecond = new Publisher("publisherSecond");
        Publisher publisherThird = new Publisher("publisherThird");
        entityManager.persist(publisherFirst);
        entityManager.persist(publisherSecond);
        entityManager.persist(publisherThird);

        Role admin = new Role("admin");
        Role user = new Role("user");
        entityManager.persist(admin);
        entityManager.persist(user);


        User petr = new User("Petr", "admin", new Contact("1265838", "admin@mail.com"), admin);
        User ivan = new User("Ivan", "user", new Contact("2334538", "user@mail.com"), user);
        entityManager.persist(petr);
        entityManager.persist(ivan);

        Genre scientific = new Genre("Научный");
        Genre comedy = new Genre("Комедия");
        entityManager.persist(scientific);
        entityManager.persist(comedy);

        Book bookFirst = new Book("Java", scientific, authorThird, publisherFirst, 123, "image", 10, "description");
        Book bookSecond = new Book("C+", scientific, authorThird, publisherFirst, 223, "image", 10, "description");
        Book bookThird = new Book("Комедия", comedy, authorSecond, publisherSecond, 444, "image", 10, "description");
        entityManager.persist(bookFirst);
        entityManager.persist(bookSecond);
        entityManager.persist(bookThird);

        Review reviewFirst = new Review(bookFirst, petr, "good!");
        Review reviewSecond = new Review(bookSecond, ivan, "bad!");
        Review reviewThird = new Review(bookThird, ivan, "bad!");
        entityManager.persist(reviewFirst);
        entityManager.persist(reviewSecond);
        entityManager.persist(reviewThird);

        Vote voteFirst = new Vote(BigDecimal.valueOf(5), bookFirst);
        Vote voteSecond = new Vote(BigDecimal.valueOf(4), bookFirst);
        Vote voteThird = new Vote(BigDecimal.valueOf(3), bookSecond);
        entityManager.persist(voteFirst);
        entityManager.persist(voteSecond);
        entityManager.persist(voteThird);

        UserBook userBookFirst = new UserBook(petr, bookFirst, LocalDate.now(), LocalDate.now().plusMonths(1));
        UserBook userBookSecond = new UserBook(petr, bookSecond, LocalDate.now(), LocalDate.now().plusMonths(1));
        UserBook userBookThird = new UserBook(ivan, bookThird, LocalDate.now(), LocalDate.now().plusMonths(1));
        entityManager.persist(userBookFirst);
        entityManager.persist(userBookSecond);
        entityManager.persist(userBookThird);

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
