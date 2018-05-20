package by.itacademy.dao.impl;

import by.itacademy.dao.interfaces.ReviewDao;
import by.itacademy.entity.Review;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.hibernate.Session;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ReviewDaoImpl extends BaseDao<Long, Review> implements ReviewDao {

    public static final ReviewDaoImpl INSTANCE = new ReviewDaoImpl();

    @Override
    public List<Review> findByBookId(Long bookId) {
        try(Session session = SESSION_FACTORY.openSession()){
            return session.createQuery("", Review.class)
                    .list();
        }
    }

    public static ReviewDaoImpl getInstance() {
        return INSTANCE;
    }
}
