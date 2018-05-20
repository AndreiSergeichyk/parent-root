package by.itacademy.dao;

import by.itacademy.entity.Publisher;
import org.junit.Test;

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
}
