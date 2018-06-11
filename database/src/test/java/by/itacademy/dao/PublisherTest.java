package by.itacademy.dao;

import by.itacademy.entity.Publisher;
import by.itacademy.repository.initerface.PublisherRepository;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;

public class PublisherTest extends BaseCase {

    @Autowired
    private PublisherRepository publisherRepository;

    @Test
    public void findPublisher() {
        Iterable<Publisher> publishers = publisherRepository.findAll();
        ArrayList<Publisher> result = new ArrayList<>();
        publishers.forEach(result::add);
        assertThat(result, hasSize(3));
        Publisher publisher = result.get(0);
        Optional<Publisher> publisher1 = publisherRepository.findById(publisher.getId());
        Assert.assertTrue(publisher1.isPresent());
    }

    @Test
    public void savePublisher() {
        Publisher publisher = new Publisher("Тест8");
        publisher = publisherRepository.save(publisher);
        Assert.assertNotNull("Id is null", publisher);
    }

    @Test
    public void findAll() {
        Iterable<Publisher> publishers = publisherRepository.findAll();
        ArrayList<Publisher> results = new ArrayList<>();
        publishers.forEach(results::add);
        assertThat(results, hasSize(3));
        List<String> names = results.stream().map(Publisher::getName).collect(toList());
        assertThat(names, contains("publisherFirst", "publisherSecond", "publisherThird"));
    }
}
