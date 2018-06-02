package by.itacademy.dao.impl;

import by.itacademy.dao.interfaces.VoteDao;
import by.itacademy.entity.Vote;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Repository
public class VoteDaoImpl extends BaseDao<Long, Vote> implements VoteDao {

    @Override
    public Double findByBookId(Long bookId) {
        return sessionFactory.getCurrentSession()
                .createQuery("select avg (v.value) from Vote v join v.book b " +
                        "where b.id = :bookId", Double.class)
                .setParameter("bookId", bookId)
                .getSingleResult();
    }
}
