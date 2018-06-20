package by.itacademy.dao;

import by.itacademy.entity.Book;
import by.itacademy.repository.initerface.BookRepository;
import by.itacademy.repository.initerface.VoteRepository;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;

import java.math.BigDecimal;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;

public class VoteTest extends BaseCase {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private VoteRepository voteRepository;

    @Test
    public void findByBookId() {
        List<Book> books = bookRepository.findAllByNameContainingIgnoreCase("java", PageRequest.of(0, 5));
        Book book = books.get(0);
        BigDecimal avgVote = voteRepository.avgVote(book.getId());
        Assert.assertThat(avgVote, equalTo(BigDecimal.valueOf(4.5)));
    }
}
