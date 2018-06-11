package by.itacademy.service;

import by.itacademy.entity.Publisher;
import by.itacademy.service.interfaces.PublisherService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertThat;

public class PublisherTest extends BaseCase {

    @Autowired
    private PublisherService publisherService;

    @Test
    public void findAll() {
        List<Publisher> publishers = publisherService.findAll();
        Assert.assertNotNull("publisher is null", publishers);
        List<String> names = publishers.stream().map(Publisher::getName).collect(toList());
        assertThat(names, contains("publisherFirst", "publisherSecond", "publisherThird"));
    }
}
