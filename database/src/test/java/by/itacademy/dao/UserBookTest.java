package by.itacademy.dao;

import by.itacademy.entity.User;
import by.itacademy.entity.UserBook;
import by.itacademy.repository.initerface.UserBookRepository;
import by.itacademy.repository.initerface.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;

public class UserBookTest extends BaseCase {

    @Autowired
    private UserBookRepository userBookRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void findByUserId(){
        Optional<User> user = userRepository.findByNameAndPassword("Petr", "admin");
        Assert.assertTrue(user.isPresent());
        List<UserBook> userBooks = userBookRepository.findAllByUserId(user.get().getId());
        assertThat(userBooks, hasSize(2));
    }
}
