package by.itacademy.dao.impl;

import by.itacademy.dao.interfaces.UserBookDao;
import by.itacademy.entity.Book;
import by.itacademy.entity.UserBook;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.hibernate.Session;

import java.io.Serializable;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserBookDaoImpl extends BaseDao<Long, UserBook> implements UserBookDao {

    public static final UserBookDao INSTANCE = new UserBookDaoImpl();

    @Override
    public List<UserBook> findByUserId(Long userId) {
        try (Session session = SESSION_FACTORY.openSession()) {
            return session.createQuery("select ub from UserBook  ub join ub.user u " +
                    "where u.id = :userId order by ub.dateIssue", UserBook.class)
                    .setParameter("userId", userId)
                    .list();
        }
    }

    @Override
    public Long save(UserBook userBook) {
        try (Session session = SESSION_FACTORY.openSession()) {
            session.beginTransaction();

            Book book = userBook.getBook();
            book.setNumberCopies(book.getNumberCopies() - 1);

            session.update(book);
            Serializable id = session.save(userBook);

            session.getTransaction().commit();

            return (Long) id;
        }
    }

    @Override
    public void delete(UserBook userBook) {
        try (Session session = SESSION_FACTORY.openSession()) {
            session.beginTransaction();

            Book book = userBook.getBook();
            book.setNumberCopies(book.getNumberCopies() + 1);

            session.update(book);
            session.delete(userBook);
        }
    }

    public static UserBookDao getInstance() {
        return INSTANCE;
    }
}
