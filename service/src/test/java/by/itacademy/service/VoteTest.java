package by.itacademy.service;

import by.itacademy.entity.Book;
import by.itacademy.service.interfaces.BookService;
import by.itacademy.service.interfaces.VoteService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

import static org.hamcrest.CoreMatchers.equalTo;

public class VoteTest extends BaseCase {

    @Autowired
    private VoteService voteService;

    @Autowired
    private BookService bookService;

    @Test
    public void findByBookId() {
        Book book = bookService.findBooksByNameLikeIgnoreCase("java");
        Assert.assertNotNull("Book is null", book);
        BigDecimal avgVote = voteService.avgVote(book.getId());
        Assert.assertThat(avgVote, equalTo(BigDecimal.valueOf(4.5)));
    }
}
