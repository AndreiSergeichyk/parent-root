package by.itacademy.service.interfaces;

import by.itacademy.entity.Vote;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public interface VoteService extends ServiceInt<Long, Vote> {

    List<Vote> findAllByBookId(Serializable bookId);

    BigDecimal avgVote(Serializable bookId);
}
