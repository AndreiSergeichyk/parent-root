package by.itacademy.service;

import by.itacademy.entity.User;
import by.itacademy.entity.UserBook;
import by.itacademy.service.interfaces.UserBookService;
import by.itacademy.service.interfaces.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;

public class UserBookTest extends BaseCase {

    @Autowired
    private UserBookService userBookService;

    @Autowired
    private UserService userService;

    @Test
    public void findByUserId() {
        User user = userService.findByNameAndPassword("Petr", "admin");
        Assert.assertNotNull("User is null", user);
        List<UserBook> userBooks = userBookService.findAllByUserId(user.getId());
        assertThat(userBooks, hasSize(2));
    }
}
