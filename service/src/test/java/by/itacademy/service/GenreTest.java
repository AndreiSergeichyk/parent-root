package by.itacademy.service;

import by.itacademy.entity.Genre;
import by.itacademy.service.interfaces.GenreService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class GenreTest extends BaseCase {

    @Autowired
    private GenreService genreService;

    @Test
    public void findByName() {
        Genre genre = genreService.findByName("Научный");
        Assert.assertEquals(genre.getName(), "Научный");
    }

    @Test
    public void findAll(){
        List<Genre> genres = genreService.findAll();
        Assert.assertNotNull("Entity is null", genres);
    }
}
