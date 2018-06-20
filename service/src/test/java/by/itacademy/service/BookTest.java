package by.itacademy.service;

import by.itacademy.entity.Book;
import by.itacademy.entity.Genre;
import by.itacademy.service.interfaces.BookService;
import by.itacademy.service.interfaces.GenreService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;

public class BookTest extends BaseCase {

    @Autowired
    private BookService bookService;

    @Autowired
    private GenreService genreService;

    @Test
    public void findAllBy() {
        List<Book> books = bookService.findAllBy(1, 2);
        assertThat(books, hasSize(2));
    }

    @Test
    public void findByAuthorName() {
        List<Book> results = bookService.findAllByAuthor("authorSecond", 1, 5);
        assertThat(results, hasSize(1));
    }

    @Test
    public void findByGenreName() {
        Genre genre = genreService.findByName("Научный");
        Assert.assertNotNull("Genre is Null", genre);
        List<Book> results = bookService.findAllByGenreName(genre.getName(), 1, 5);
        assertThat(results, hasSize(2));
        List<String> names = results.stream().map(Book::getName).collect(toList());
        assertThat(names, contains("Java", "C+"));
    }

    @Test
    public void findByLetter() {
        List<Book> results = bookService.findBooksByLetter("c", 1, 5);
        assertThat(results, hasSize(1));
        List<String> names = results.stream().map(Book::getName).collect(toList());
        assertThat(names, contains("C+"));
    }

    @Test
    public void findByRating() {
        List<Book> results = bookService.findByRating();
        assertThat(results, hasSize(2));
        List<String> names = results.stream().map(Book::getName).collect(toList());
        assertThat(names, contains("C+", "Java"));
    }

    @Test
    public void findByName() {
        List<Book> books = bookService.findBooksByName("Java", 1, 5);
        Book java = books.get(0);
        assertThat(java.getName(), equalTo("Java"));
    }

    @Test
    public void countBook() {
        Integer booksSize = bookService.countBooks();
        Assert.assertNotNull("entity is null", booksSize);
    }

    @Test
    public void update() {
        List<Book> books = bookService.findAll();
        Book book = books.get(0);
        book.setNumberCopies(0);
        int count = bookService.updateBook(book);
        assertThat(count, equalTo(1));
    }
}
