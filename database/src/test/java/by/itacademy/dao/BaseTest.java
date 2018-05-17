package by.itacademy.dao;


import by.itacademy.entity.BaseEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;

import java.util.Arrays;

public class BaseTest {

    public static SessionFactory FACTORY;

    @BeforeClass
    public static void before() {
        FACTORY = new Configuration().configure().buildSessionFactory();
    }

    @AfterClass
    public static void after() {
        FACTORY.close();
    }

    public <T extends BaseEntity<?>> void save(T... objects) {
        try (Session session = FACTORY.openSession()) {
            session.beginTransaction();

            Arrays.asList(objects).forEach(it -> {
                session.save(it);
                Assert.assertNotNull("Id is null", it.getId());
            });

            session.getTransaction().commit();
        }
    }

    public <T extends BaseEntity<?>> void find(T... objects) {
        try (Session session = FACTORY.openSession()) {
            session.beginTransaction();

            Arrays.asList(objects).forEach(it -> {
                session.save(it);
                Assert.assertNotNull("Id is null", it.getId());
                session.evict(it);

                session.find(it.getClass(), it.getId());
                Assert.assertNotNull("Entity is null", it);
            });
            session.getTransaction().commit();
        }
    }
}
