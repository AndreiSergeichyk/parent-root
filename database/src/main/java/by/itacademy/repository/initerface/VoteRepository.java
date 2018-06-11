package by.itacademy.repository.initerface;

import by.itacademy.entity.Vote;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public interface VoteRepository extends CrudRepository<Vote, Long> {

    List<Vote> findAllByBookId(Serializable bookId);

    @Query("select avg (v.value) from Vote v join v.book b where b.id = :bookId")
    BigDecimal avgVote(@Param("bookId") Serializable bookId);
}
