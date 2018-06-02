package by.itacademy.repository.initerface;

import by.itacademy.entity.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

    List<Book> findAllBy(org.springframework.data.domain.Pageable pageable);

    List<Book> findAllByGenreId(Serializable genreId);

    List<Book> findAllByAuthorNameLikeIgnoreCase(String authorName);

    Optional<Book> findBooksByNameLikeIgnoreCase(String bookName);

    List<Book> findBooksByNameStartingWithIgnoreCase(String letter);

    @Query("select b from Book b join b.votes v group by b.id order by avg (v.value)")
    List<Book> findByRating();
}
