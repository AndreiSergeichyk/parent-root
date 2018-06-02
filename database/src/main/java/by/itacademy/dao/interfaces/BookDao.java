package by.itacademy.dao.interfaces;

import by.itacademy.entity.Book;

import java.util.List;

public interface BookDao extends Dao<Long, Book> {

    List<Book> findAll(Integer limit, Integer offset);

    List<Book> findByGenreId(Long genreId, Integer limit, Integer offset);

    List<Book> findByAuthorName(String authorName, Integer limit, Integer offset);

    Book findByName(String name);

    List<Book> findByLetter(String letter, Integer limit, Integer offset);

    List<Book> findByRating(Integer limit, Integer offset);
}
