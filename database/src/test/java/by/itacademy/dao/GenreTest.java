package by.itacademy.dao;

import by.itacademy.dao.impl.GenreDaoImpl;
import by.itacademy.entity.Genre;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class GenreTest extends BaseTest {

    @Autowired
    private GenreDaoImpl genreDao;

    @Test
    public void saveGenre() {
        Genre genre = new Genre("Боевик5");
        Long genreId = genreDao.save(genre);
        Assert.assertNotNull("Id is Null!", genreId);
    }

    @Test
    public void findGenre() {
        Genre genre = genreDao.findByName("Научный");
        Assert.assertNotNull("Entity is null", genre);
        genreDao.findById(genre.getId());
        assertThat(genre.getName(), equalTo("Научный"));
    }

    @Test
    public void findByName() {
        Genre genre = genreDao.findByName("Научный");
        assertThat(genre.getName(), equalTo("Научный"));
    }
}
