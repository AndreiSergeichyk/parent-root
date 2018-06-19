package by.itacademy.dao;

import by.itacademy.entity.Author;
import by.itacademy.entity.Book;
import by.itacademy.entity.Genre;
import by.itacademy.entity.Publisher;
import by.itacademy.repository.initerface.AuthorRepository;
import by.itacademy.repository.initerface.BookRepository;
import by.itacademy.repository.initerface.GenreRepository;
import by.itacademy.repository.initerface.PublisherRepository;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class BookTest extends BaseCase {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private PublisherRepository publisherRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private GenreRepository genreRepository;

    @Test
    public void saveBook() {
        Genre genre = new Genre("Художественный3");
        Author author = new Author("А.Дюма3");
        Publisher publisher = new Publisher("Тест3");
        Book book = new Book("Граф Монте-Кристо3", genre, author, publisher,
                643, "image3", 133, "description3");

        genre = genreRepository.save(genre);
        Assert.assertNotNull("Enyity is null", genre);
        author = authorRepository.save(author);
        Assert.assertNotNull("Entity is null", author);
        publisher = publisherRepository.save(publisher);
        Assert.assertNotNull("Entity is null", publisher);
        book = bookRepository.save(book);
        Assert.assertNotNull("Entity is null", book);
    }

    @Test
    public void findBook() {
        List<Book> results = bookRepository.findAllByNameContainingIgnoreCase("Java", PageRequest.of(0, 5));
        Book book = results.get(0);
        Optional<Book> findBook = bookRepository.findById(book.getId());
        assertThat(findBook.get().getName(), equalTo("Java"));
    }

    @Test
    public void findByAuthorName() {
        List<Book> results = bookRepository.findAllByAuthorNameContainingIgnoreCase("authorSe", PageRequest.of(0, 5));
        assertThat(results, hasSize(1));
    }

    @Test
    public void findByGenreId() {
        Optional<Genre> genre = genreRepository.findByName("Научный");
        assertTrue(genre.isPresent());
        String genreName = genre.get().getName();
        List<Book> results = bookRepository.findAllByGenreName(genreName, PageRequest.of(0, 5));
        assertThat(results, hasSize(2));
        List<String> names = results.stream().map(Book::getName).collect(toList());
        assertThat(names, contains("Java", "C+"));
    }

    @Test
    public void findByLetter() {
        List<Book> results = bookRepository.findBooksByNameStartingWithIgnoreCase("c", PageRequest.of(0, 5));
        assertThat(results, hasSize(1));
        List<String> names = results.stream().map(Book::getName).collect(toList());
        assertThat(names, contains("C+"));
    }

    @Test
    public void findByRating() {
        List<Book> results = bookRepository.findByRating();
        assertThat(results, hasSize(2));
        List<String> names = results.stream().map(Book::getName).collect(toList());
        assertThat(names, contains("C+", "Java"));
    }

    @Test
    public void findByName() {
        List<Book> results = bookRepository.findAllByNameContainingIgnoreCase("C", PageRequest.of(0, 5));
        assertTrue(!results.isEmpty());
    }

    @Test
    public void findAllBy() {
        Iterable<Book> books = bookRepository.findAllBy(PageRequest.of(0, 5));
        List<Book> values = new ArrayList<>();
        books.forEach(values::add);
        assertThat(values, hasSize(2));
    }
}
