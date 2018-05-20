package by.itacademy.dao.interfaces;

import java.math.BigDecimal;

public interface VoteDao {

    BigDecimal findByBookId(Long bookId);
}
