package by.itacademy.dao.impl;

import by.itacademy.dao.interfaces.GenreDao;
import by.itacademy.entity.Genre;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Repository
public class GenreDaoImpl extends BaseDao<Long, Genre> implements GenreDao {

    @Override
    public Genre findByName(String name) {
        return sessionFactory.getCurrentSession()
                .createQuery("select g from Genre g where g.name = :name", Genre.class)
                .setParameter("name", name)
                .getSingleResult();
    }
}
