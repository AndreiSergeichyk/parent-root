package by.itacademy.dao;

import by.itacademy.entity.Genre;
import org.junit.Test;

public class GenreTest extends BaseTest {

    @Test
    public void saveGenre() {
        Genre genre = new Genre("Боевик5");
        save(genre);
    }

    @Test
    public void findGenre() {
        Genre genre = new Genre("Боевик6");
        find(genre);
    }
}
