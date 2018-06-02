package by.itacademy.dao.impl;

import by.itacademy.dao.interfaces.ReviewDao;
import by.itacademy.entity.Review;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Repository
public class ReviewDaoImpl extends BaseDao<Long, Review> implements ReviewDao {

    @Override
    public List<Review> findByBookId(Long bookId) {
        return sessionFactory.getCurrentSession()
                .createQuery("select r from Review r join r.book b where b.id = :bookId", Review.class)
                .setParameter("bookId", bookId)
                .list();
    }
}
