package by.itacademy.dao;

import by.itacademy.entity.Book;
import by.itacademy.entity.Review;
import by.itacademy.repository.initerface.BookRepository;
import by.itacademy.repository.initerface.ReviewRepository;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

public class ReviewTest extends BaseCase {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @Test
    public void findByBookId() {
        Optional<Book> book = bookRepository.findBooksByNameLikeIgnoreCase("Java");
        Assert.assertTrue(book.isPresent());
        Long bookId = book.get().getId();
        List<Review> results = reviewRepository.findAllByBookId(bookId);
        assertThat(results, hasSize(1));
    }
}
