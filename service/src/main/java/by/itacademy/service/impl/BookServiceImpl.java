package by.itacademy.service.impl;

import by.itacademy.entity.Book;
import by.itacademy.repository.initerface.BookRepository;
import by.itacademy.service.interfaces.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BookServiceImpl implements BookService {

    private static final int MINUS_ONE = 1;
    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book save(Book object) {
        return bookRepository.save(object);
    }

    @Override
    public void delete(Book object) {
        bookRepository.delete(object);
    }

    @Override
    public Book findById(Long id) {
        Book book = null;
        Optional<Book> result = bookRepository.findById(id);
        if (result.isPresent()) {
            book = result.get();
        }

        return book;
    }

    @Override
    public List<Book> findAll() {
        ArrayList<Book> list = new ArrayList<>();
        Iterable<Book> books = bookRepository.findAll();
        books.forEach(list::add);

        return list;
    }

    @Override
    public List<Book> findAllBy(Integer numberPage, Integer countBookOnPage) {
        return bookRepository.findAllBy(PageRequest.of(numberPage - MINUS_ONE, countBookOnPage));
    }

    @Override
    public List<Book> findAllByGenreName(String genreName, Integer numberPage, Integer countBookOnPage) {
        return bookRepository.findAllByGenreName(genreName, PageRequest.of(numberPage - MINUS_ONE, countBookOnPage));
    }

    @Override
    public Integer countBooksByGenreName(String genreName) {
        return bookRepository.countBooksByGenreName(genreName);
    }

    @Override
    public List<Book> findAllByAuthor(String authorName, Integer numberPage, Integer countBookOnPage) {
        return bookRepository.findAllByAuthorNameContainingIgnoreCase(authorName, PageRequest.of(numberPage - MINUS_ONE, countBookOnPage));
    }

    @Override
    public Integer countBooksByAuthorName(String authorName) {
        return bookRepository.countBooksByAuthorNameContainingIgnoreCase(authorName.toUpperCase());
    }

    @Override
    public List<Book> findBooksByName(String bookName, Integer numberPage, Integer countBookOnPage) {
        return bookRepository.findAllByNameContainingIgnoreCase(bookName, PageRequest.of(numberPage - MINUS_ONE, countBookOnPage));
    }

    @Override
    public Integer countBooksByBookName(String bookName) {
        return bookRepository.countBooksByNameContainingIgnoreCase(bookName.toUpperCase());
    }

    @Override
    public List<Book> findBooksByLetter(String letter, Integer numberPage, Integer countBookOnPage) {
        return bookRepository.findBooksByNameStartingWithIgnoreCase(letter, PageRequest.of(numberPage - MINUS_ONE, countBookOnPage));
    }

    @Override
    public Integer countBooksByFirstLetter(String letter) {
        return bookRepository.countBooksByNameStartingWithIgnoreCase(letter);
    }

    @Override
    public List<Book> findByRating() {
        return bookRepository.findByRating();
    }

    @Override
    public Integer countBooks() {
        return bookRepository.countBooks();
    }

    @Override
    public int updateBook(Book book) {
        return bookRepository.updateBook(book.getNumberCopies(), book.getId());
    }
}
