package by.itacademy.dao;

import by.itacademy.dao.impl.AuthorDaoImpl;
import by.itacademy.entity.Author;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;

public class AuthorTest extends BaseTest {

    @Autowired
    private AuthorDaoImpl authorDao;

    @Test
    public void saveAuthor() {
        Author author = new Author("A.Дюма1");
        Long authorId = authorDao.save(author);
        Assert.assertNotNull("Id is null", authorId);
    }

    @Test
    public void findAuthor() {
        Author author = new Author("A.Дюма2");
        Long authorId = authorDao.save(author);
        Assert.assertNotNull("Id is null", authorId);
        author = authorDao.findById(authorId);
        assertThat(author.getName(), equalTo("A.Дюма2"));
    }

    @Test
    public void findAll() {
        List<Author> results = authorDao.findAll();
        assertThat(results, hasSize(2));
        List<String> names = results.stream().map(Author::getName).collect(toList());
        assertThat(names, contains("authorSecond", "authorThird"));
    }
}
