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
        List<Book> books = bookService.findAllBy(PageRequest.of(0, 2));
        assertThat(books, hasSize(2));
    }

    @Test
    public void findByAuthorName() {
        List<Book> results = bookService.findAllByAuthorNameLikeIgnoreCase("authorSecond");
        assertThat(results, hasSize(1));
    }

    @Test
    public void findByGenreId() {
        Genre genre = genreService.findByName("Научный");
        Assert.assertNotNull("Genre is Null", genre);
        List<Book> results = bookService.findAllByGenreId(genre.getId());
        assertThat(results, hasSize(2));
        List<String> names = results.stream().map(Book::getName).collect(toList());
        assertThat(names, contains("Java", "C+"));
    }

    @Test
    public void findByLetter() {
        List<Book> results = bookService.findBooksByNameStartingWithIgnoreCase("c");
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
        Book java = bookService.findBooksByNameLikeIgnoreCase("Java");
        assertThat(java.getName(), equalTo("Java"));
    }
}
