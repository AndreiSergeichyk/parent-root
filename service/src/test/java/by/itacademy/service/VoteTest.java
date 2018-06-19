package by.itacademy.service;

import by.itacademy.entity.Book;
import by.itacademy.entity.Vote;
import by.itacademy.service.interfaces.BookService;
import by.itacademy.service.interfaces.VoteService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;

import java.math.BigDecimal;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;

public class VoteTest extends BaseCase {

    @Autowired
    private VoteService voteService;

    @Autowired
    private BookService bookService;

    @Test
    public void findByBookId() {
        List<Book> books = bookService.findBooksByName("java", 1, 5);
        Book book = books.get(0);
        Assert.assertNotNull("Book is null", book);
        BigDecimal avgVote = voteService.avgVote(book.getId());
        Assert.assertThat(avgVote, equalTo(BigDecimal.valueOf(4.5)));
    }

    @Test
    public void saveVote() {
        Vote vote = new Vote(BigDecimal.valueOf(5));
        voteService.save(vote);
    }

    @Test
    public void deleteVote() {
        List<Vote> votes = voteService.findAll();
        Vote vote = votes.get(0);
        voteService.delete(vote);
    }

    @Test
    public void findAll() {
        List<Vote> votes = voteService.findAll();
    }
}
