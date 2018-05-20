package by.itacademy.dao.impl;

import by.itacademy.dao.interfaces.VoteDao;
import by.itacademy.entity.Vote;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.hibernate.Session;

import java.math.BigDecimal;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class VoteDaoImpl extends BaseDao<Long, Vote> implements VoteDao {

    public static final VoteDaoImpl INSTANCE = new VoteDaoImpl();

    @Override
    public BigDecimal findByBookId(Long bookId) {
        try (Session session = SESSION_FACTORY.openSession()) {
            return session.createQuery("select avg (v.value) from Vote v join v.book b " +
                    "where b.id = :bookId", BigDecimal.class)
                    .setParameter("bookId", bookId)
                    .getSingleResult();
        }
    }

    public static VoteDaoImpl getInstance() {
        return INSTANCE;
    }
}
