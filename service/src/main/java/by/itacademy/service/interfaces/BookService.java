package by.itacademy.service.interfaces;

import by.itacademy.entity.Book;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public interface BookService extends ServiceInt<Long, Book> {

    List<Book> findAllBy(Pageable pageable);

    List<Book> findAllByGenreId(Serializable genreId);

    List<Book> findAllByAuthorNameLikeIgnoreCase(String authorName);

    Book findBooksByNameLikeIgnoreCase(String bookName);

    List<Book> findBooksByNameStartingWithIgnoreCase(String letter);

    List<Book> findByRating();
}
