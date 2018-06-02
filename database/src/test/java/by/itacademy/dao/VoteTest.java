package by.itacademy.dao;

import by.itacademy.dao.impl.AuthorDaoImpl;
import by.itacademy.dao.impl.BookDaoImpl;
import by.itacademy.dao.impl.GenreDaoImpl;
import by.itacademy.dao.impl.PublisherDaoImpl;
import by.itacademy.dao.impl.VoteDaoImpl;
import by.itacademy.entity.Author;
import by.itacademy.entity.Book;
import by.itacademy.entity.Genre;
import by.itacademy.entity.Publisher;
import by.itacademy.entity.Vote;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;

public class VoteTest extends BaseTest {

    @Autowired
    private AuthorDaoImpl authorDao;

    @Autowired
    private PublisherDaoImpl publisherDao;

    @Autowired
    private BookDaoImpl bookDao;

    @Autowired
    private GenreDaoImpl genreDao;

    @Autowired
    private VoteDaoImpl voteDao;

    @Test
    public void saveVote() {
        Genre genre = new Genre("Художественный17");
        Author author = new Author("А.Дюма17");
        Publisher publisher = new Publisher("Тест17");
        Book book = new Book("Граф Монте-Кристо17", genre, author, publisher,
                617, "image17", 17, "description17");
        Vote vote = new Vote(new BigDecimal(4.7), book);

        Long genreId = genreDao.save(genre);
        Assert.assertNotNull("Id is Null", genreId);
        Long authorId = authorDao.save(author);
        Assert.assertNotNull("Id is Null", authorId);
        Long publisherId = publisherDao.save(publisher);
        Assert.assertNotNull("Id is Null", publisherId);
        Long bookId = bookDao.save(book);
        Assert.assertNotNull("Id is Null", bookId);
        Long voteId = voteDao.save(vote);
        Assert.assertNotNull("Id is Null", voteId);
    }

    @Test
    public void findVote() {
        List<Vote> votes = voteDao.findAll();
        assertThat(votes, hasSize(3));
        Vote vote = votes.get(0);
        vote = voteDao.findById(vote.getId());
        Assert.assertThat(vote.getValue(), equalTo(vote.getValue()));
    }

    @Test
    public void findByBookId() {
        Book book = bookDao.findByName("Java");
        Long bookId = book.getId();
        Assert.assertNotNull("Id is Null", bookId);
        Double avgVote = voteDao.findByBookId(bookId);
        Assert.assertThat(avgVote, equalTo(4.5));
    }
}
