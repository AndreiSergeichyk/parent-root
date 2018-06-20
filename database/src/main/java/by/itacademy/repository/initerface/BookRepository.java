package by.itacademy.repository.initerface;

import by.itacademy.entity.Book;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

    List<Book> findAllBy(Pageable pageable);

    @Query("select count (b.id) from Book  b ")
    Integer countBooks();

    List<Book> findAllByGenreName(String genreName, Pageable pageable);

    @Query("select count (b.id) from Book  b join b.genre g where g.name = :genreName")
    Integer countBooksByGenreName(@Param("genreName") String genreName);

    List<Book> findAllByAuthorNameContainingIgnoreCase(String authorName, Pageable pageable);

    int countBooksByAuthorNameContainingIgnoreCase(String author);

    List<Book> findAllByNameContainingIgnoreCase(String bookName, Pageable pageable);

    int countBooksByNameContainingIgnoreCase(String bookName);

    List<Book> findBooksByNameStartingWithIgnoreCase(String letter, Pageable pageable);

    int countBooksByNameStartingWithIgnoreCase(String letter);

    @Query("select b from Book b join b.votes v group by b.id order by avg (v.value)")
    List<Book> findByRating();

    @Modifying
    @Query("update Book b set b.numberCopies = :numberCopies where b.id = :id")
    int updateBook(@Param("numberCopies") Integer numberCopies, @Param("id") Long id);
}