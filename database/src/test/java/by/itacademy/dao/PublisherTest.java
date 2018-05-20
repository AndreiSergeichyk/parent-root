package by.itacademy.dao;

import by.itacademy.dao.impl.BookDaoImpl;
import by.itacademy.dao.impl.PublisherDaoImpl;
import by.itacademy.entity.Book;
import by.itacademy.entity.Publisher;
import org.junit.Test;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;

public class PublisherTest extends BaseTest {

    @Test
    public void savePublisher() {
        Publisher publisher = new Publisher("Тест7");
        save(publisher);
    }

    @Test
    public void findPublisher() {
        Publisher publisher = new Publisher("Тест8");
        find(publisher);
    }

    @Test
    public void findAll() {
        List<Publisher> results = PublisherDaoImpl.getInstance().findAll(5, 0);
        assertThat(results, hasSize(3));
        List<String> names = results.stream().map(Publisher::getName).collect(toList());
        assertThat(names, contains("publisherFirst", "publisherSecond", "publisherThird"));
    }
}
