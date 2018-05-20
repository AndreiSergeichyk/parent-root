package by.itacademy.dao;

import by.itacademy.dao.impl.BookDaoImpl;
import by.itacademy.dao.impl.GenreDaoImpl;
import by.itacademy.entity.Author;
import by.itacademy.entity.Book;
import by.itacademy.entity.Genre;
import by.itacademy.entity.Publisher;
import org.junit.Test;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;

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
        List<Book> results = BookDaoImpl.getInstance().findByAuthorName("authorSecond", 5, 0);
        assertThat(results, hasSize(1));
    }

    @Test
    public void findByGenreId() {
        Genre genre = GenreDaoImpl.getInstance().findByName("Научный");
        Long genreId = genre.getId();
        List<Book> results = BookDaoImpl.getInstance().findByGenreId(genreId, 5, 0);
        assertThat(results, hasSize(2));
        List<String> names = results.stream().map(Book::getName).collect(toList());
        assertThat(names, contains("Java", "C+"));
    }

    @Test
    public void findByLetter() {
        List<Book> results = BookDaoImpl.getInstance().findByLetter("C", 5, 0);
        assertThat(results, hasSize(1));
        List<String> names = results.stream().map(Book::getName).collect(toList());
        assertThat(names, contains("C+"));
    }

    @Test
    public void findByRating() {
        List<Book> results = BookDaoImpl.getInstance().findByRating(5, 0);
        assertThat(results, hasSize(2));
        List<String> names = results.stream().map(Book::getName).collect(toList());
        assertThat(names, contains("C+", "Java"));
    }

    @Test
    public void findByName() {
        Book book = BookDaoImpl.getInstance().findByName("Java");
        assertThat(book.getName(), equalTo("Java"));
    }
}
