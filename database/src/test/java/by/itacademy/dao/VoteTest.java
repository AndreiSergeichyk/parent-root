package by.itacademy.dao;

import by.itacademy.entity.Book;
import by.itacademy.repository.initerface.BookRepository;
import by.itacademy.repository.initerface.VoteRepository;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class VoteTest extends BaseCase {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private VoteRepository voteRepository;

    @Test
    public void findByBookId() {
        Optional<Book> book = bookRepository.findBooksByNameLikeIgnoreCase("java");
        assertTrue(book.isPresent());
        BigDecimal avgVote = voteRepository.avgVote(book.get().getId());
        Assert.assertThat(avgVote, equalTo(BigDecimal.valueOf(4.5)));
    }
}
