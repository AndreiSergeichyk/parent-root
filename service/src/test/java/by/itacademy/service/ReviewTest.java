package by.itacademy.service;

import by.itacademy.entity.Book;
import by.itacademy.entity.Review;
import by.itacademy.service.interfaces.BookService;
import by.itacademy.service.interfaces.ReviewService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

public class ReviewTest extends BaseCase {

    @Autowired
    private ReviewService reviewService;

    @Autowired
    private BookService bookService;

    @Test
    public void findByBookId() {
        Book book = bookService.findBooksByNameLikeIgnoreCase("Java");
        Assert.assertNotNull("book is null", book);
        List<Review> results = reviewService.findAllByBookId(book.getId());
        assertThat(results, hasSize(1));
    }
}
