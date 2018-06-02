package by.itacademy.service.interfaces;

import by.itacademy.entity.Genre;

public interface GenreService extends ServiceInt<Long, Genre> {

    Genre findByName(String genreName);
}
