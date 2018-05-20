package by.itacademy.dao;

import by.itacademy.dao.impl.AuthorDaoImpl;
import by.itacademy.entity.Author;
import by.itacademy.entity.Book;
import org.junit.Test;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;

public class AuthorTest extends BaseTest {

    @Test
    public void saveAuthor() {
        Author author = new Author("A.Дюма1");
        save(author);
    }

    @Test
    public void getAuthor() {
        Author author = new Author("A.Дюма2");
        find(author);
    }

    @Test
    public void findAll() {
        List<Author> results = AuthorDaoImpl.getInstance().findAll(5, 0);
        assertThat(results, hasSize(2));
        List<String> names = results.stream().map(Author::getName).collect(toList());
        assertThat(names, contains("authorSecond", "authorThird"));
    }
}
