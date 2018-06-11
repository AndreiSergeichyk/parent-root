package by.itacademy.service.impl;

import by.itacademy.entity.Book;
import by.itacademy.repository.initerface.BookRepository;
import by.itacademy.service.interfaces.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BookServiceImpl implements BookService {

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
    public List<Book> findAllBy(Pageable pageable) {
        return bookRepository.findAllBy(pageable);
    }

    @Override
    public List<Book> findAllByGenreId(Serializable genreId) {
        return bookRepository.findAllByGenreId(genreId);
    }

    @Override
    public List<Book> findAllByAuthorNameLikeIgnoreCase(String authorName) {
        return bookRepository.findAllByAuthorNameLikeIgnoreCase(authorName);
    }

    @Override
    public Book findBooksByNameLikeIgnoreCase(String bookName) {
        Book book = null;
        Optional<Book> result = bookRepository.findBooksByNameLikeIgnoreCase(bookName);
        if (result.isPresent()) {
            book = result.get();
        }

        return book;
    }

    @Override
    public List<Book> findBooksByNameStartingWithIgnoreCase(String letter) {
        return bookRepository.findBooksByNameStartingWithIgnoreCase(letter);
    }

    @Override
    public List<Book> findByRating() {
        return bookRepository.findByRating();
    }
}
