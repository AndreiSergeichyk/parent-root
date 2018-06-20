package by.itacademy.service.impl;

import by.itacademy.entity.UserBook;
import by.itacademy.repository.initerface.BookRepository;
import by.itacademy.repository.initerface.UserBookRepository;
import by.itacademy.service.interfaces.UserBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserBookServiceImpl implements UserBookService {

    public static final int MINUS_BOOK = 1;
    private final UserBookRepository userBookRepository;
    private final BookRepository bookRepository;

    @Autowired
    public UserBookServiceImpl(UserBookRepository userBookRepository, BookRepository bookRepository) {
        this.userBookRepository = userBookRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public List<UserBook> findAllByUserId(Serializable userId) {
        return userBookRepository.findAllByUserId(userId);
    }

    @Override
    public UserBook save(UserBook userBook) {
        int newCountBook = userBook.getBook().getNumberCopies() - MINUS_BOOK;
        bookRepository.updateBook(newCountBook, userBook.getBook().getId());

        return userBookRepository.save(userBook);
    }

    @Override
    public void delete(UserBook object) {
        userBookRepository.delete(object);
    }

    @Override
    public UserBook findById(Long id) {
        UserBook userBook = null;
        Optional<UserBook> result = userBookRepository.findById(id);
        if (result.isPresent()) {
            userBook = result.get();
        }

        return userBook;
    }

    @Override
    public List<UserBook> findAll() {
        ArrayList<UserBook> userBooks = new ArrayList<>();
        Iterable<UserBook> result = userBookRepository.findAll();
        result.forEach(userBooks::add);

        return userBooks;
    }
}
