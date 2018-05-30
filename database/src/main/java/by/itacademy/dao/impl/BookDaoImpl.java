package by.itacademy.dao.impl;

import by.itacademy.dao.interfaces.BookDao;
import by.itacademy.entity.Book;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Repository
public class BookDaoImpl extends BaseDao<Long, Book> implements BookDao {

    @Override
    public List<Book> findAll(Integer limit, Integer offset) {
        return sessionFactory.getCurrentSession().createQuery("select b from Book b", Book.class)
                .setFirstResult(offset)
                .setMaxResults(limit)
                .list();
    }

    @Override
    public List<Book> findByGenreId(Long genreId, Integer limit, Integer offset) {
        return sessionFactory.getCurrentSession().createQuery("select b from Book b " +
                "join b.genre g where g.id = :genreId", Book.class)
                .setParameter("genreId", genreId)
                .setFirstResult(offset)
                .setMaxResults(limit)
                .list();
    }

    @Override
    public List<Book> findByAuthorName(String authorName, Integer limit, Integer offset) {
        return sessionFactory.getCurrentSession().createQuery("select b from Book b " +
                "join b.author a where a.name = :authorName", Book.class)
                .setParameter("authorName", authorName)
                .setFirstResult(offset)
                .setMaxResults(limit)
                .list();
    }

    @Override
    public Book findByName(String name) {
        return sessionFactory.getCurrentSession()
                .createQuery("select b from Book b where upper(b.name) like :name ", Book.class)
                .setParameter("name", name.toUpperCase())
                .getSingleResult();
    }

    @Override
    public List<Book> findByLetter(String letter, Integer limit, Integer offset) {
        return sessionFactory.getCurrentSession().createQuery("select b from Book b " +
                "where substring(b.name, 1, 1) = :letter", Book.class)
                .setParameter("letter", letter)
                .setFirstResult(offset)
                .setMaxResults(limit)
                .getResultList();
    }

    @Override
    public List<Book> findByRating(Integer limit, Integer offset) {
        return sessionFactory.getCurrentSession().createQuery("select b from Book b " +
                "join b.votes v group by b.name order by avg (v.value)", Book.class)
                .list();
    }
}
