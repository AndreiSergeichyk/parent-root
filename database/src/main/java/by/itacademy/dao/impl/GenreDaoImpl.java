package by.itacademy.dao.impl;

import by.itacademy.dao.interfaces.GenreDao;
import by.itacademy.entity.Genre;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.hibernate.Session;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class GenreDaoImpl extends BaseDao<Long, Genre> implements GenreDao {

    public static final GenreDaoImpl INSTANCE = new GenreDaoImpl();

    @Override
    public List<Genre> findAll(Integer limit, Integer offset) {
        try (Session session = SESSION_FACTORY.openSession()) {
            return session.createQuery("select g from Genre g", Genre.class)
                    .setFirstResult(offset)
                    .setMaxResults(limit)
                    .list();
        }
    }

    public static GenreDaoImpl getInstance() {
        return INSTANCE;
    }
}
