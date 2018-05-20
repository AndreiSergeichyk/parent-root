package by.itacademy.dao.interfaces;

import by.itacademy.entity.Genre;

import java.util.List;

public interface GenreDao extends Dao<Long, Genre> {

    List<Genre> findAll(Integer limit, Integer offset);

    Genre findByName(String name);
}
