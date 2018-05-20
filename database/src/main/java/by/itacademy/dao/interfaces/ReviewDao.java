package by.itacademy.dao.interfaces;

import by.itacademy.entity.Review;

import java.util.List;

public interface ReviewDao {

    List<Review> findByBookId(Long bookId);
}
