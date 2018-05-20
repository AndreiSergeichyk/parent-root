package by.itacademy.dao.impl;

import by.itacademy.dao.interfaces.AuthorDao;
import by.itacademy.entity.Author;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.hibernate.Session;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AuthorDaoImpl extends BaseDao<Long, Author> implements AuthorDao {

    public static final AuthorDaoImpl INSTANCE = new AuthorDaoImpl();

    @Override
    public List<Author> findAll(Integer limit, Integer offset) {
        try (Session session = SESSION_FACTORY.openSession()) {
            return session.createQuery("select a from Author a", Author.class)
                    .setFirstResult(offset)
                    .setMaxResults(limit)
                    .list();
        }
    }

    public static AuthorDaoImpl getInstance() {
        return INSTANCE;
    }
}
