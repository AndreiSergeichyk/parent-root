package by.itacademy.service.impl;

import by.itacademy.entity.Review;
import by.itacademy.repository.initerface.ReviewRepository;
import by.itacademy.service.interfaces.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;

    @Autowired
    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public List<Review> findAllByBookId(Serializable bookId) {
        return reviewRepository.findAllByBookId(bookId);
    }

    @Override
    public Review save(Review object) {
        return reviewRepository.save(object);
    }

    @Override
    public void delete(Review object) {
        reviewRepository.delete(object);
    }

    @Override
    public Review findById(Long id) {
        Review review = null;
        Optional<Review> result = reviewRepository.findById(id);
        if (result.isPresent()) {
            review = result.get();
        }

        return review;
    }

    @Override
    public List<Review> findAll() {
        ArrayList<Review> reviews = new ArrayList<>();
        Iterable<Review> result = reviewRepository.findAll();
        result.forEach(reviews::add);

        return reviews;
    }
}
