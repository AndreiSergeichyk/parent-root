package by.itacademy.dao.interfaces;

import by.itacademy.entity.Author;

import java.util.List;

public interface AuthorDao extends Dao<Long, Author> {

    List<Author> findAll(Integer limit, Integer offset);
}
