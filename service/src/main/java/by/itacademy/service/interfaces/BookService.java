package by.itacademy.service.interfaces;

import by.itacademy.entity.Book;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public interface BookService extends ServiceInt<Long, Book> {

    List<Book> findAllBy(Integer numberPage, Integer countBookOnPage);

    Integer countBooks();

    List<Book> findAllByGenreName(String genreName, Integer numberPage, Integer countBookOnPage);

    Integer countBooksByGenreName(String genreName);

    List<Book> findAllByAuthor(String authorName, Integer numberPage, Integer countBookOnPage);

    Integer countBooksByAuthorName(String authorName);

    List<Book> findBooksByName(String bookName, Integer numberPage, Integer countBookOnPage);

    Integer countBooksByBookName(String bookName);

    List<Book> findBooksByLetter(String letter, Integer numberPage, Integer countBookOnPage);

    Integer countBooksByFirstLetter(String letter);

    List<Book> findByRating();

    int updateBook(Book book);
}
