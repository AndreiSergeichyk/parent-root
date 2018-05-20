package by.itacademy.dao.impl;

import by.itacademy.dao.interfaces.PublisherDao;
import by.itacademy.entity.Publisher;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.hibernate.Session;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PublisherDaoImpl extends BaseDao<Long, Publisher> implements PublisherDao {

    public static final PublisherDaoImpl INSTANCE = new PublisherDaoImpl();

    @Override
    public List<Publisher> findAll(Integer limit, Integer offset) {
        try (Session session = SESSION_FACTORY.openSession()) {
            return session.createQuery("select p from Publisher p", Publisher.class)
                    .setFirstResult(offset)
                    .setMaxResults(limit)
                    .list();
        }
    }

    public static PublisherDaoImpl getInstance() {
        return INSTANCE;
    }
}
