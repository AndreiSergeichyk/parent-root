package by.itacademy.dao;

import by.itacademy.dao.impl.PublisherDaoImpl;
import by.itacademy.entity.Publisher;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;

public class PublisherTest extends BaseTest {

    @Autowired
    private PublisherDaoImpl publisherDao;

    @Test
    public void findPublisher() {
        List<Publisher> publishers = publisherDao.findAll();
        assertThat(publishers, hasSize(3));
        Publisher publisher = publishers.get(0);
        publisher = publisherDao.findById(publisher.getId());
        Assert.assertNotNull("Entity is Null!", publisher);
    }

    @Test
    public void savePublisher() {
        Publisher publisher = new Publisher("Тест8");
        Long publisherId = publisherDao.save(publisher);
        Assert.assertNotNull("Id is null", publisherId);
    }

    @Test
    public void findAll() {
        List<Publisher> results = publisherDao.findAll();
        assertThat(results, hasSize(3));
        List<String> names = results.stream().map(Publisher::getName).collect(toList());
        assertThat(names, contains("publisherFirst", "publisherSecond", "publisherThird"));
    }
}
