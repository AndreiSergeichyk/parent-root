package by.itacademy.dao;


import by.itacademy.entity.BaseEntity;
import by.itacademy.manager.SessionFactoryManager;
import by.itacademy.util.TestDataImporter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;

import java.util.Arrays;

public class BaseTest {

    public static SessionFactory FACTORY;

    @Before
    public void clean() {
        FACTORY = SessionFactoryManager.getSessionFactory();
        try (Session session = FACTORY.openSession()) {
            session.beginTransaction();
            session.createQuery("delete from UserBook ").executeUpdate();
            session.createQuery("delete from Vote ").executeUpdate();
            session.createQuery("delete from Review ").executeUpdate();
            session.createQuery("delete from Book ").executeUpdate();
            session.createQuery("delete from User ").executeUpdate();
            session.createQuery("delete from Role ").executeUpdate();
            session.createQuery("delete from Genre ").executeUpdate();
            session.createQuery("delete from Author ").executeUpdate();
            session.createQuery("delete from Publisher ").executeUpdate();

            session.getTransaction().commit();

            TestDataImporter.getInstance().importTestData(FACTORY);
        }
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
