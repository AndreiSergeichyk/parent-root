package by.itacademy.dao;

import by.itacademy.dao.impl.AuthorDaoImpl;
import by.itacademy.dao.impl.BookDaoImpl;
import by.itacademy.dao.impl.GenreDaoImpl;
import by.itacademy.dao.impl.PublisherDaoImpl;
import by.itacademy.entity.Author;
import by.itacademy.entity.Book;
import by.itacademy.entity.Genre;
import by.itacademy.entity.Publisher;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;

public class BookTest extends BaseTest {

    @Autowired
    private AuthorDaoImpl authorDao;

    @Autowired
    private PublisherDaoImpl publisherDao;

    @Autowired
    private BookDaoImpl bookDao;

    @Autowired
    private GenreDaoImpl genreDao;

    @Test
    public void saveBook() {
        Genre genre = new Genre("Художественный3");
        Author author = new Author("А.Дюма3");
        Publisher publisher = new Publisher("Тест3");
        Book book = new Book("Граф Монте-Кристо3", genre, author, publisher,
                643, "image3", 133, "description3");

        Long genreId = genreDao.save(genre);
        Assert.assertNotNull("Id is null", genreId);
        Long authorId = authorDao.save(author);
        Assert.assertNotNull("Id is null", authorId);
        Long publisherId = publisherDao.save(publisher);
        Assert.assertNotNull("Id is null", publisherId);
        Long bookId = bookDao.save(book);
        Assert.assertNotNull("Id is null", bookId);
    }

    @Test
    public void findBook() {
        Book book = bookDao.findByName("Java");
        Assert.assertNotNull("Entity is null", book);
        book = bookDao.findById(book.getId());
        assertThat(book.getName(), equalTo("Java"));
    }

    @Test
    public void findByAuthorName() {
        List<Book> results = bookDao.findByAuthorName("authorSecond", 5, 0);
        assertThat(results, hasSize(1));
    }

    @Test
    public void findByGenreId() {
        Genre genre = genreDao.findByName("Научный");
        Assert.assertNotNull("Entity is null", genre);
        Long genreId = genre.getId();
        List<Book> results = bookDao.findByGenreId(genreId, 5, 0);
        assertThat(results, hasSize(2));
        List<String> names = results.stream().map(Book::getName).collect(toList());
        assertThat(names, contains("Java", "C+"));
    }

    @Test
    public void findByLetter() {
        List<Book> results = bookDao.findByLetter("C", 5, 0);
        assertThat(results, hasSize(1));
        List<String> names = results.stream().map(Book::getName).collect(toList());
        assertThat(names, contains("C+"));
    }

    @Test
    public void findByRating() {
        List<Book> results = bookDao.findByRating(5, 0);
        assertThat(results, hasSize(2));
        List<String> names = results.stream().map(Book::getName).collect(toList());
        assertThat(names, contains("C+", "Java"));
    }

    @Test
    public void findByName() {
        Book book = bookDao.findByName("Java");
        assertThat(book.getName(), equalTo("Java"));
    }
}
