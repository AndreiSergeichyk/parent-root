package by.itacademy.service.interfaces;

import by.itacademy.entity.Review;

import java.io.Serializable;
import java.util.List;

public interface ReviewService extends ServiceInt<Long, Review> {

    List<Review> findAllByBookId(Serializable bookId);
}
