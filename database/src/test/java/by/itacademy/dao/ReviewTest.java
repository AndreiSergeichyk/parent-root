package by.itacademy.dao;

import by.itacademy.entity.Book;
import by.itacademy.entity.Review;
import by.itacademy.repository.initerface.BookRepository;
import by.itacademy.repository.initerface.ReviewRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

public class ReviewTest extends BaseCase {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @Test
    public void findByBookId() {
        List<Book> books = bookRepository.findAllByNameContainingIgnoreCase("Java", PageRequest.of(0, 5));
        Book book = books.get(0);
        Long bookId = book.getId();
        List<Review> results = reviewRepository.findAllByBookId(bookId);
        assertThat(results, hasSize(1));
    }
}
