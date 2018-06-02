package by.itacademy.repository.initerface;

import by.itacademy.entity.Review;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;
import java.util.List;

public interface ReviewRepository extends CrudRepository<Review, Long> {

    List<Review> findAllByBookId(Serializable bookId);
}
