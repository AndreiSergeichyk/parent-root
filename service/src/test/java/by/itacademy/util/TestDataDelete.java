package by.itacademy.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

@Component
public class TestDataDelete {

    private final EntityManagerFactory entityManagerFactory;

    @Autowired
    public TestDataDelete(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    public void deleteTestData() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.createQuery("delete from UserBook ").executeUpdate();
        entityManager.createQuery("delete from Vote ").executeUpdate();
        entityManager.createQuery("delete from Review ").executeUpdate();
        entityManager.createQuery("delete from Book ").executeUpdate();
        entityManager.createQuery("delete from User ").executeUpdate();
        entityManager.createQuery("delete from Role ").executeUpdate();
        entityManager.createQuery("delete from Genre ").executeUpdate();
        entityManager.createQuery("delete from Author ").executeUpdate();
        entityManager.createQuery("delete from Publisher ").executeUpdate();
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
