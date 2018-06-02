package by.itacademy.dao.impl;

import by.itacademy.dao.interfaces.UserBookDao;
import by.itacademy.entity.UserBook;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Repository
public class UserBookDaoImpl extends BaseDao<Long, UserBook> implements UserBookDao {

    @Override
    public List<UserBook> findByUserId(Long userId) {
        return sessionFactory.getCurrentSession().createQuery("select ub from UserBook  ub join ub.user u " +
                "where u.id = :userId order by ub.dateIssue", UserBook.class)
                .setParameter("userId", userId)
                .list();
    }
}
