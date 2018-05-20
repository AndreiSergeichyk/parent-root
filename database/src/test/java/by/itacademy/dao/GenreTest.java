package by.itacademy.dao;

import by.itacademy.dao.impl.GenreDaoImpl;
import by.itacademy.entity.Genre;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

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

    @Test
    public void findByName() {
        Genre genre = GenreDaoImpl.getInstance().findByName("Научный");
        assertThat(genre.getName(), equalTo("Научный"));
    }
}
