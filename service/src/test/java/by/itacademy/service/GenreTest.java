package by.itacademy.service;

import by.itacademy.entity.Genre;
import by.itacademy.service.interfaces.GenreService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class GenreTest extends BaseCase {

    @Autowired
    private GenreService genreService;

    @Test
    public void findByName() {
        Genre genre = genreService.findByName("Научный");
        Assert.assertEquals(genre.getName(), "Научный");
    }
}
